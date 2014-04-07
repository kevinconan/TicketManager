/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevin.tm.util;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 *
 * @author Diluka
 */
public class ClauseMaker {

    public static String makeClause(Class<? extends Object> clazz, String clauseString) {
        StringBuilder searchClause = new StringBuilder();

        Field[] fields = clazz.getFields();
        String[] names = new String[fields.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = fields[i].getName();
        }

        final String baseClause = new StringBuilder("concat").append(Arrays.toString(names).replace('[', '(').replace(']', ')')).append("like '%REPLACE_HERE%'").toString();
        final String replaceString = "REPLACE_HERE";

        if (clauseString == null || clauseString.equals("{}")) {
            searchClause.append(" true ");
        } else {
            String[] searchKeys = clauseString.trim().split("\\s+");
            for (String key : searchKeys) {
                searchClause.append(baseClause.replaceAll(replaceString, key)).append(" and ");
            }
            searchClause.append("true");
        }

        return searchClause.toString();
    }
}
