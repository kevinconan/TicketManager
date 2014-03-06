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

import com.google.gson.Gson;

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
    
    private Map<String, Object> msgMap ;
    public Map<String, Object> getMsgMap() {
		return msgMap;
	}

	public void setMsgMap(Map<String, Object> msgMap) {
		this.msgMap = msgMap;
	}

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
    	msgMap = new HashMap<>();
    	Gson gson = new Gson();
    	BusBean busBean=gson.fromJson(jsonData, BusBean.class);
    	System.out.println(jsonData);
    	if(ValidationUtil.isNullOrEmpty(busBean)){
    		msgMap.put("success", true);
    		msgMap.put("msg", "fail");
    		return "MSGMAP";
    	}
    	int count = this.busService.save(busBean);	
	if (count > 0) {
		msgMap.put("success", true);
		msgMap.put("msg", "ok");
	//	System.out.println(msgMap.isEmpty());
	} else if(count == 0 ){
		msgMap.put("success", true);
		msgMap.put("msg", "fail");
	}else if(count < 0) {
		msgMap.put("success", true);
		msgMap.put("msg", "repeat");
	}else{
		msgMap.put("success", false);
		msgMap.put("msg", "fail");
	}

	return "MSGMAP";
    }

    public String delete(String vehicleNo) {
	if (this.busService.deleteByVehicleNo(vehicleNo) != 0) {
	    this.message = "0";

	} else {
	    this.message = "1";
	}

	return MESSAGE;
    }

    public String update() {
    	msgMap = new HashMap<>();
    	Gson gson = new Gson();
    	BusBean busBean=gson.fromJson(jsonData, BusBean.class);
    	System.out.println(jsonData);
    	if(ValidationUtil.isNullOrEmpty(busBean)){
    		msgMap.put("success", true);
    		msgMap.put("msg", "fail");
    		return "MSGMAP";
    	}
    	int count = this.busService.update(busBean);	
    	if (count > 0) {
    		msgMap.put("success", true);
    		msgMap.put("msg", "ok");
    	//	System.out.println(msgMap.isEmpty());
    	} else if(count == 0 ){
    		msgMap.put("success", true);
    		msgMap.put("msg", "fail");
    	}else{
    		msgMap.put("success", false);
    		msgMap.put("msg", "fail");
    	}

	return "MSGMAP";
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
