/**
 * 
 */
package kevin.tm.action;

import java.util.HashMap;

import kevin.tm.dao.model.RouteScheduleBean;
import kevin.tm.dao.model.Scheduleinfo;
import kevin.tm.service.ScheduleInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * @author Diluka
 * 
 */
@Scope("request")
@Controller("scheduleinfoAction")
public class ScheduleinfoAction extends BaseAction<Scheduleinfo> {

    /**
     * 
     */
    private static final long serialVersionUID = -3917050847693231758L;

    @Autowired
    private ScheduleInfoService service;

    public String list() {
    	if(message == null)
    		message = "{}";
    	JsonElement jsonElement = GSON.fromJson(message, JsonElement.class);

        if (jsonElement.isJsonArray()) {
            jsonElement = jsonElement.getAsJsonArray().get(0);
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
	this.list = this.service.findByPage(this.start, this.limit,jsonObject);

	this.map = new HashMap<String, Object>();
	this.map.put(TOTAL_COUNT, this.service.totalCount());
	this.map.put(DATA, this.list);
	return MAP;
    }
    
    public String getById() {
    	Object object = GSON.fromJson(this.message, Object.class);
    	Scheduleinfo bean = this.service
    		.findById((int) Double.parseDouble(object.toString()));

    	this.map = new HashMap<>();
    	this.map.put(SUCCESS, true);
    	this.map.put(DATA, bean);
    	return MAP;
        }
    
}
