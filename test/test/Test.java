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
	String json = gson.toJson(new Object[] { 1, '2', 3, "4" });
	System.out.println(json);
	Object[] objects = gson.fromJson(json, Object[].class);
	for (Object object : objects) {
	    // System.out.println(object);
	    System.out.println((int) Double.parseDouble(object.toString()));
	}
    }
}
