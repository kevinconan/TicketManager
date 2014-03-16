/**
 *
 */
package kevin.tm.action;

import com.google.gson.JsonElement;
import java.util.HashMap;
import kevin.tm.dao.model.Ticketinfo;
import kevin.tm.service.TicketInfoService;
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
        this.list = this.service.findByPage(this.start, this.limit);

        this.map = new HashMap<>();
        this.map.put(TOTAL_COUNT, this.service.totalCount());
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
}
