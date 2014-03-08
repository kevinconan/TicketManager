/**
 * 
 */
package test;

import com.google.gson.Gson;

/**
 * @author Diluka
 * 
 */
public class Test {
    private static final Gson gson = new Gson();

    /**
     * @param args
     */
    public static void main(String[] args) {
	System.out.println(gson.toJson(1));
    }
}
