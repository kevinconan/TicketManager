/**
 * 
 */
package kevin.tm.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kevin.tm.dao.model.BusBean;
import kevin.tm.model.BusBeanExt;
import kevin.tm.service.BusService;
import kevin.tm.util.ValidationUtil;

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
    
    private Map<String, Object> dataMap ;
    public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public BusBean getBusBean() {
		return busBean;
	}

	public void setBusBean(BusBean busBean) {
		this.busBean = busBean;
	}

	private BusBean busBean;

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
    public String add() {
    	System.out.println(busBean.getVehicleno());
    	if(busBean == null){
    		this.message = "1";
    		return MESSAGE;
    	}
    		
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
    
    public String getByVehicleNo(){
    	String vehicleno=busBean.getVehicleno();
   //	setBusBean(busService.findByVehicleNo(vehicleno));
    	dataMap = new HashMap<>();
    	if (!ValidationUtil.isNullOrEmpty(busBean)){
    		dataMap.put("success", true);
    		
    		dataMap.put("data", busService.findByVehicleNo(vehicleno));
    	}else{
    		dataMap.put("success", false);
    	}
    	return "BUSBEAN";
    }

}
