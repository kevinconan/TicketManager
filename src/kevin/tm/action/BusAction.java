/**
 * 
 */
package kevin.tm.action;

import java.util.List;

import kevin.tm.model.BusBeanExt;
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
public class BusAction extends BaseAction<BusBeanExt> {

    /**
     * 
     */
    private static final long serialVersionUID = 7467813069003588100L;
    private List<BusBeanExt> busList;

    public List<BusBeanExt> getBusList() {
	return this.busList;
    }

    public void setBusList(List<BusBeanExt> busList) {
	this.busList = busList;
    }

    @Autowired
    private BusService busService;

    public BusService getBusService() {
	return this.busService;
    }

    public void setBusService(BusService busService) {
	this.busService = busService;
    }

    /**
     * 
     * 添加BUS信息
     * 
     * @author Kevin
     * 
     * */
    public String Add(BusBeanExt busBean) {
	if (this.busService.save(busBean) != 0) {
	    this.message = "0";

	} else {
	    this.message = "1";
	}

	return MESSAGE;
    }

    public String delete(String vehicleNo) {
	if (this.busService.deleteByVehicleNo(vehicleNo) != 0) {
	    this.message = "0";

	} else {
	    this.message = "1";
	}

	return MESSAGE;
    }

    public String update(BusBeanExt busBean) {
	if (this.busService.update(busBean) != 0) {
	    this.message = "0";

	} else {
	    this.message = "1";
	}

	return MESSAGE;
    }

    public String list() {
	this.setBusList(this.busService.findAll());
	return LIST;
    }

}
