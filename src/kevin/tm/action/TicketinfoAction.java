/**
 *
 */
package kevin.tm.action;

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
}
