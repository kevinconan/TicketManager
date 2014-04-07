/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevin.tm.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Diluka
 */
public class ClauseMaker {

    private static final String REPLACE_STRING = "DiX" + String.valueOf(Math.random());
    private static final Map<Class<? extends Object>, String> baseMap = new HashMap<>();
    private static final String TRUE_STRING = " true ";
    private static final String AND_STRING = " and ";

    private static String getBaseString(Class<? extends Object> clazz) {
        if (baseMap.containsKey(clazz)) {
            return baseMap.get(clazz);
        } else {
            Field[] fields = clazz.getDeclaredFields();
            String[] names = new String[fields.length];
            for (int i = 0; i < names.length; i++) {
                names[i] = fields[i].getName();
            }

            String baseClause = new StringBuilder("concat").append(Arrays.toString(names).replace('[', '(').replace(']', ')')).append(" like '%").append(REPLACE_STRING).append("%'").toString();
            baseMap.put(clazz, baseClause);
            return baseClause;
        }
    }

    public static String makeClause(Class<? extends Object> clazz, String clauseString) {
        String baseClause = getBaseString(clazz);

        if (clauseString == null || clauseString.isEmpty() || clauseString.equals("{}")) {
            return TRUE_STRING;
        } else {
            StringBuilder searchClause = new StringBuilder();
            String[] searchKeys = clauseString.trim().split("\\s+");
            for (String key : searchKeys) {
                searchClause.append(baseClause.replaceAll(REPLACE_STRING, key)).append(AND_STRING);
            }
            return searchClause.delete(searchClause.length() - AND_STRING.length(), searchClause.length() - 1).toString();
        }
    }

    public static String makeClause(Object object, String clauseString) {
        return makeClause(object.getClass(), clauseString);
    }
}
