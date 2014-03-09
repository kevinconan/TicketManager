/**
 * 
 */
package test;

import kevin.tm.dao.model.StationBean;

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
	String json = "[{\"stationid\":\"\",\"stationname\":\"231\",\"locationx\":\"2314\",\"locationy\":\"342\"}]";
	json = json.replaceAll("\"\"", "null");
	System.out.println(json);
	StationBean[] beans = gson.fromJson(json, StationBean[].class);
	for (StationBean bean : beans) {
	    // System.out.println(object);
	    System.out.println(bean);
	}
    }
}
