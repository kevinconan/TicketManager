package kevin.tm.util;

import java.util.List;
import java.util.Map;

/**
 * 各种数据类型验证工具类
 * 
 * @author wuge
 * 
 */
public class ValidationUtil {
	/**
	 * 对象的非空校验
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNullOrEmpty(Object value) {
		return value == null;
	}

	/**
	 * 字符串对象的非空校验
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}
	/**
	 * 字符串对象的非空校验
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNullOrEmpty1(String value) {
		return value == null || value.isEmpty()||value.equals("")||value.equals(" ");
	}
	/**
	 * 字符串对象的非空校验
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNullOrEmptyStr(String value) {
		return value == null || value.isEmpty()||value.equals("")||value.equals("[]");
	}

	/**
	 * 整形对象的非空校验
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNullOrZero(Integer value) {
		return value == null || value == 0;
	}

	/**
	 * 长整形对象的非空校验
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNullOrZero(Long value) {
		return value == null || value == 0;
	}

	/**
	 * 布尔对象的非空校验
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNullOrFalse(Boolean value) {
		return value == null || !value;
	}

	/**
	 * 数组的非空校验
	 * 
	 * @param list
	 * @return
	 */
	public static <T extends Object> boolean isNullOrEmpty(T[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 对象集合的非空校验
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isNullOrEmpty(List<? extends Object> list) {
		return list == null || list.isEmpty();
	}
	
	/**
	 * 对象键值对集合的非空校验
	 * @param map
	 * @return
	 */
	public static boolean isNullOrEmpty(Map<? extends Object, ? extends Object> map){
		return map == null || map.size() == 0;
	}
}
