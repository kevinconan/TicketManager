/**
 * 
 */
package kevin.tm.interceptor;

import java.sql.Connection;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.RowBounds;

/**
 * 对应Oracle数据库的= =
 * 
 * @author Leeyee
 * @see http://leeyee.github.io/blog/2013/05/26/mybatis-simple-pagination/
 */
@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }))
public class PaginationInterceptor implements Interceptor {
    private final static String SQL_SELECT_REGEX = "(?is)^\\s*SELECT.*$";
    private final static String SQL_COUNT_REGEX = "(?is)^\\s*SELECT\\s+COUNT\\s*\\(\\s*(?:\\*|\\w+)\\s*\\).*$";

    @Override
    public Object intercept(Invocation inv) throws Throwable {
	StatementHandler target = (StatementHandler) inv.getTarget();
	BoundSql boundSql = target.getBoundSql();
	String sql = boundSql.getSql();
	if (StringUtils.isBlank(sql)) {
	    return inv.proceed();
	}
	System.out.println("origin sql>>>>>" + sql.replaceAll("\n", ""));
	// 只有为select查询语句时才进行下一步
	if (sql.matches(SQL_SELECT_REGEX)
		&& !Pattern.matches(SQL_COUNT_REGEX, sql)) {
	    Object obj = FieldUtils.readField(target, "delegate", true);
	    // 反射获取 RowBounds 对象。
	    RowBounds rowBounds = (RowBounds) FieldUtils.readField(obj,
		    "rowBounds", true);
	    // 分页参数存在且不为默认值时进行分页SQL构造
	    if (rowBounds != null && rowBounds != RowBounds.DEFAULT) {
		FieldUtils.writeField(boundSql, "sql",
			this.newSql(sql, rowBounds), true);
		System.out.println("new sql>>>>>"
			+ boundSql.getSql().replaceAll("\n", ""));
		// 一定要还原否则将无法得到下一组数据(第一次的数据被缓存了)
		FieldUtils.writeField(rowBounds, "offset",
			RowBounds.NO_ROW_OFFSET, true);
		FieldUtils.writeField(rowBounds, "limit",
			RowBounds.NO_ROW_LIMIT, true);
	    }
	}
	return inv.proceed();
    }

    public String newSql(String oldSql, RowBounds rowBounds) {
	// this is for OracleDB
	// String start =
	// " SELECT * FROM   (SELECT   row_.*, ROWNUM rownum_ FROM ( ";
	// String end = " ) row_ WHERE   ROWNUM <= " + rowBounds.getLimit()
	// + ") WHERE   rownum_ > " + rowBounds.getOffset();
	String start = "SELECT * FROM (";
	String end = ") AS t LIMIT " + rowBounds.getLimit() + ","
		+ rowBounds.getOffset();
	return start + oldSql + end;
    }

    @Override
    public Object plugin(Object target) {
	return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties arg0) {
	System.out.println(arg0);
    }
    /*
     * //测试正则表达式是否能正常工作 public static void main(String[] args) { String
     * SQL_SELECT_REGEX = "^\\s*SELECT.*$"; String SQL_COUNT_REGEX =
     * "^\\s*SELECT\\s+COUNT\\s*\\(\\s*(?:\\*|\\w+)\\s*\\).*$"; List<String>
     * tests = new ArrayList<String>();
     * tests.add("select count(*) from abc \n\t\t where\n abc");
     * tests.add("SELECT   COUNT(*) from abc");
     * tests.add(" select count  (*) from abc");
     * tests.add("  select count(  *) from abc");
     * tests.add("select count( *  ),id   from abc");
     * tests.add("select * from abc");
     * tests.add("select abc,test,fdas from abc");
     * tests.add("select count(adb) from abc");
     * tests.add("select count(0) from abc");
     * tests.add("select min(count(*)) from abc");
     * tests.add("update min(count(*)) from abc");
     * tests.add("delete min(count(*)) from abc"); Pattern p1 =
     * Pattern.compile(SQL_SELECT_REGEX, Pattern.DOTALL |
     * Pattern.CASE_INSENSITIVE); Pattern p2 = Pattern.compile(SQL_COUNT_REGEX,
     * Pattern.DOTALL | Pattern.CASE_INSENSITIVE); for (String str : tests) {
     * Matcher m1 = p1.matcher(str); Matcher m2 = p2.matcher(str);
     * System.out.println("匹配字符串: " + str); System.out.println("    是select语句? "
     * + m1.matches()); System.out.println("    是count语句? " + m2.matches());
     * System.out.println(); } }
     */
}
