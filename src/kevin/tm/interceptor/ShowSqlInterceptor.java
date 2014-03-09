/**
 * 
 */
package kevin.tm.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/**
 * @author Diluka
 * 
 */
@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }))
public class ShowSqlInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation inv) throws Throwable {
	StatementHandler target = (StatementHandler) inv.getTarget();
	BoundSql boundSql = target.getBoundSql();
	String sql = boundSql.getSql();
	System.out.println(sql);
	return inv.proceed();
    }

    @Override
    public Object plugin(Object target) {
	return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties arg0) {
	System.out.println(arg0);

    }
}
