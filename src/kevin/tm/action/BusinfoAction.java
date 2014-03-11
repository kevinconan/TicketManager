/**
 * 
 */
package kevin.tm.action;

import java.util.HashMap;

import kevin.tm.dao.model.Businfo;
import kevin.tm.service.BusInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Diluka
 * 
 */
@Scope("request")
@Controller("businfoAction")
public class BusinfoAction extends BaseAction<Businfo> {

    /**
     * 
     */
    private static final long serialVersionUID = 6693084509185779796L;

    @Autowired
    private BusInfoService service;

    public String list() {
	this.list = this.service.findByPage(this.start, this.limit);

	this.map = new HashMap<String, Object>();
	this.map.put(TOTAL_COUNT, this.service.totalCount());
	this.map.put(DATA, this.list);
	return MAP;
    }
}
