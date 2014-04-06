/**
 *
 */
package test;

import javassist.expr.NewArray;
import kevin.tm.dao.model.Scheduleinfo;
import kevin.tm.util.ReflectUtil;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

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
        /*String json = "[{\"stationid\":\"\",\"stationname\":\"abc\",\"locationx\":\"2314\",\"locationy\":\"342\"}]";
        json = json.replaceAll("\"\"", "null");
        System.out.println(json);
        JsonElement jsonElement = gson.fromJson(json, JsonElement.class);
        System.out.println(jsonElement);
        System.out.println(jsonElement.isJsonArray());
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        System.out.println(jsonArray.get(0).getAsJsonObject().get("stationname").getAsInt());*/
    	
    	ReflectUtil.getMembers(new Scheduleinfo());
    }
}
