/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevin.tm.util;

import java.lang.reflect.Method;

/**
 *
 * @author Diluka
 */
public class ExampleMaker {

    public static <T> T makeExample(T example, String clauseString) {
        try {
            String[] clauses = clauseString.trim().split("\\s+");
            Object criteria = example.getClass().getMethod("createCriteria", null).invoke(example, null);
            for (String clause : clauses) {
                for (Method meth : criteria.getClass().getMethods()) {
                    if (meth.getName().toLowerCase().contains("like")) {
                        meth.invoke(criteria, clause);
                    }
                }
            }
            return example;
        } catch (Exception e) {
            return null;
        }
    }
}
