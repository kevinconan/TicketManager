/**
 * 
 */
package kevin.tm.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import kevin.tm.model.BusBean;
import kevin.tm.service.BusService;

/**
 * 车辆信息请求处理Action
 * @author Kevin
 *
 */
@Scope("request")
@Controller("busAction")
public class BusAction extends BaseAction<BusBean> {

	@Autowired
	private BusService busService;

	public BusService getBusService() {
		return busService;
	}

	public void setBusService(BusService busService) {
		this.busService = busService;
	}
	
}
