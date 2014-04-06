package kevin.tm.util;

import java.lang.reflect.Field;

public class ReflectUtil {

	public static String[] getMembers(Object o){
		
		Field[] fields = o.getClass().getDeclaredFields();
		String[] members = new String[fields.length];
		for(int i=0;i < fields.length;i++){
			members[i] = fields[i].getName();
		}
		
		
		
		return members;
	}
}
