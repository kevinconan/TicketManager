/**
 *
 */
package kevin.tm.action;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kevin.tm.dao.model.Ticketinfo;
import kevin.tm.dao.model.TicketinfoExample;
import kevin.tm.service.TicketInfoService;
import kevin.tm.util.ValidationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Diluka
 *
 */
@Scope("request")
@Controller("ticketinfoAction")
public class TicketinfoAction extends BaseAction<Ticketinfo> {

    /**
     *
     */
    private static final long serialVersionUID = -6572387338226312913L;

    @Autowired
    private TicketInfoService service;

    public String list() {
    	if(message == null)
    		message = "{}";
    	JsonElement jsonElement = GSON.fromJson(message, JsonElement.class);

        if (jsonElement.isJsonArray()) {
            jsonElement = jsonElement.getAsJsonArray().get(0);
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
    	
    	
        this.list = this.service.findByPage(this.start, this.limit,jsonObject);
        int totalCount;
        if(!list.isEmpty()){
        	totalCount = this.list.get(0).getTotalCount();
        }else{
        	totalCount = 0;
        }
        this.map = new HashMap<>();
        this.map.put(TOTAL_COUNT, totalCount);
        this.map.put(DATA, this.list);
        return MAP;
    }

    public String listByScheduleid() {
        Integer id = Integer.valueOf(GSON.fromJson(message, String.class));
        list = service.findByScheduleid(id, start, limit);

        this.map = new HashMap<>();
        this.map.put(TOTAL_COUNT, this.service.countByScheduleid(id));
        this.map.put(DATA, this.list);
        return MAP;
    }

    public String listByStation() {
        JsonElement jsonElement = GSON.fromJson(message, JsonElement.class);
        if (jsonElement.isJsonArray()) {
            jsonElement = jsonElement.getAsJsonArray().get(0);
        }
        JsonElement startStation = jsonElement.getAsJsonObject().get("startstation");
        JsonElement endStation = jsonElement.getAsJsonObject().get("endstation");

        Integer startid = null;
        Integer endid = null;
        String startname = null;
        String endname = null;
        boolean flag = true;

        if (startStation != null && endStation != null) {
            try {
                startid = startStation.getAsInt();
                endid = endStation.getAsInt();
            } catch (NumberFormatException e) {
                startname = startStation.getAsString();
                endname = endStation.getAsString();
            }
        } else if (startStation != null) {
            try {
                startid = startStation.getAsInt();
            } catch (NumberFormatException e) {
                startname = startStation.getAsString();
            }
        } else if (endStation != null) {
            try {
                endid = endStation.getAsInt();
            } catch (NumberFormatException e) {
                endname = endStation.getAsString();
            }
        } else {
            flag = false;
        }

        map = new HashMap<>();
        map.put(SUCCESS, flag);
        if (flag) {
            int count;
            if (startid != null || endid != null) {
                list = service.findByStation(startid, endid, start, limit);
                count = service.countByStation(startid, endid);
            } else {
                list = service.findByStation(startname, endname, start, limit);
                count = service.countByStation(startname, endname);
            }
            map.put(TOTAL_COUNT, count);
            map.put(DATA, list);
        }

        return MAP;
    }
    /*
     schedulename:string
     customername:string
     startstationname:string
     endstationname：string
     starttime:date
     endtime:date
     checked:boolean
     routename:string
     ticketno:string
     */
    private final static String[] conditions = {"schedulename", "customername", "startstationname", "endstationname", "starttime", "endtime", "checked", "routename", "ticketno"};
    private final Map<String, JsonElement> jsonElementMap = new HashMap<>();

    {
        jsonElementMap.put("schedulename", null);
        jsonElementMap.put("customername", null);
        jsonElementMap.put("startstationname", null);
        jsonElementMap.put("endstationname", null);
        jsonElementMap.put("starttime", null);
        jsonElementMap.put("endtime", null);
        jsonElementMap.put("checked", null);
        jsonElementMap.put("routename", null);
        jsonElementMap.put("ticketno", null);
    }

    private TicketinfoExample generateExample(JsonObject jsonObject) {
        for (Map.Entry<String, JsonElement> entry : jsonElementMap.entrySet()) {
            entry.setValue(jsonObject.get(entry.getKey()));
        }

        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        TicketinfoExample.Criteria criteria = example.createCriteria();

        if (!ValidationUtil.isNullOrEmptyJson(jsonElementMap.get("schedulename"))) {
            criteria.andSchedulenameLike(jsonElementMap.get("schedulename").getAsString());
        }
        if (!ValidationUtil.isNullOrEmptyJson(jsonElementMap.get("routename"))) {
            criteria.andRoutenameLike(jsonElementMap.get("routename").getAsString());
        }
        if (!ValidationUtil.isNullOrEmptyJson(jsonElementMap.get("startstationname"))) {
            criteria.andStartstationnameLike(jsonElementMap.get("startstationname").getAsString());
        }
        if (!ValidationUtil.isNullOrEmptyJson(jsonElementMap.get("endstationname"))) {
            criteria.andEndstationnameLike(jsonElementMap.get("endstationname").getAsString());
        }
        if (!ValidationUtil.isNullOrEmptyJson(jsonElementMap.get("starttime"))) {
            criteria.andStarttimeGreaterThanOrEqualTo(new Date(jsonElementMap.get("starttime").getAsLong()));
        }
        if (!ValidationUtil.isNullOrEmptyJson(jsonElementMap.get("endtime"))) {
            criteria.andEndtimeLessThanOrEqualTo(new Date(jsonElementMap.get("endtime").getAsLong()));
        }
        if (!ValidationUtil.isNullOrEmptyJson(jsonElementMap.get("checked"))) {
            criteria.andCheckedEqualTo(jsonElementMap.get("checked").getAsBoolean());
        }
        if (!ValidationUtil.isNullOrEmptyJson(jsonElementMap.get("customername"))) {
            criteria.andCustomernameEqualTo(jsonElementMap.get("customername").getAsString());
        }
        if (!ValidationUtil.isNullOrEmptyJson(jsonElementMap.get("ticketno"))) {
            criteria.andTicketnoLike(jsonElementMap.get("ticketno").getAsString());
        }

        return example;
    }

    public String listByExample() {
        JsonElement jsonElement = GSON.fromJson(message, JsonElement.class);

        if (jsonElement.isJsonArray()) {
            jsonElement = jsonElement.getAsJsonArray().get(0);
        }

        TicketinfoExample example = generateExample(jsonElement.getAsJsonObject());
        list = service.findByExample(example, start, limit);
        int count = service.countByExample(example);

        map = new HashMap<>();
        map.put(SUCCESS, true);
        map.put(TOTAL_COUNT, count);
        map.put(DATA, list);
        return MAP;
    }
}
