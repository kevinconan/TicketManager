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

    private static final String REPLACE_STRING = String.valueOf(Math.random());
    private static final Map<Class<? extends Object>, String> baseMap = new HashMap<>();

    private static String getBaseString(Class<? extends Object> clazz) {
        if (baseMap.containsKey(clazz)) {
            return baseMap.get(clazz);
        } else {
            Field[] fields = clazz.getFields();
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
        StringBuilder searchClause = new StringBuilder();

        String baseClause = getBaseString(clazz);

        if (clauseString == null || clauseString.equals("{}")) {
            searchClause.append(" true ");
        } else {
            String[] searchKeys = clauseString.trim().split("\\s+");
            for (String key : searchKeys) {
                searchClause.append(baseClause.replaceAll(REPLACE_STRING, key)).append(" and ");
            }
            searchClause.append("true");
        }

        return searchClause.toString();
    }
}
