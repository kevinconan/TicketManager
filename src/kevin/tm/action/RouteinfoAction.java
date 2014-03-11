/**
 * 
 */
package kevin.tm.action;

import java.util.HashMap;

import kevin.tm.dao.model.Routeinfo;
import kevin.tm.service.RouteInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Diluka
 * 
 */
@Scope("request")
@Controller("routeinfoAction")
public class RouteinfoAction extends BaseAction<Routeinfo> {

    /**
     * 
     */
    private static final long serialVersionUID = 3622129331522027634L;

    @Autowired
    private RouteInfoService service;

    public String list() {
	this.list = this.service.findByPage(this.start, this.limit);

	this.map = new HashMap<String, Object>();
	this.map.put(TOTAL_COUNT, this.service.totalCount());
	this.map.put(DATA, this.list);
	return MAP;
    }
}
