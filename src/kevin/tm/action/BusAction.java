/**
 * 
 */
package kevin.tm.action;

import kevin.tm.model.BusBean;
import kevin.tm.service.BusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 车辆信息请求处理Action
 * 
 * @author Kevin
 * 
 */
@Scope("request")
@Controller("busAction")
public class BusAction extends BaseAction<BusBean> {

    /**
     * 
     */
    private static final long serialVersionUID = 7621332210140934833L;
    @Autowired
    private BusService busService;

    public BusService getBusService() {
	return this.busService;
    }

    public void setBusService(BusService busService) {
	this.busService = busService;
    }

}
