/**
 * 
 */
package kevin.tm.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kevin.tm.dao.model.RouteBean;

import kevin.tm.service.RouteService;
import kevin.tm.util.ValidationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

/**
 * 线路信息请求处理Action
 * 
 * @author Kevin
 * 
 */
@Scope("request")
@Controller("routeAction")
public class RouteAction extends BaseAction<RouteBean> {

    /**
     * 
     */
    private static final long serialVersionUID = 7467813069003588100L;
    private List<RouteBean> routeList;
    
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

	public RouteBean getRouteBean() {
		return routeBean;
	}

	public void setRouteBean(RouteBean routeBean) {
		this.routeBean = routeBean;
	}

	private RouteBean routeBean;

    public List<RouteBean> getRouteList() {
	return this.routeList;
    }

    public void setRouteList(List<RouteBean> routeList) {
	this.routeList = routeList;
    }

    @Autowired
    private RouteService routeService;

    public RouteService getRouteService() {
	return this.routeService;
    }

    public void setRouteService(RouteService routeService) {
	this.routeService = routeService;
    }

    /**
     * 
     * 添加线路信息
     * 
     * @author Kevin
     * 
     * */
    public String add() {
    	msgMap = new HashMap<>();
    	Gson gson = new Gson();
    	RouteBean routeBean=gson.fromJson(jsonData, RouteBean.class);
    	System.out.println(jsonData);
    	if(ValidationUtil.isNullOrEmpty(routeBean)){
    		msgMap.put("success", true);
    		msgMap.put("msg", "fail");
    		return "MSGMAP";
    	}
    	int count = this.routeService.save(routeBean);	
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

    public String delete() {
    msgMap = new HashMap<>();
	Gson gson = new Gson();;
	String[] busIds = gson.fromJson(jsonData, String[].class);

	for (int i = 0; i < busIds.length; i++) {
		System.out.println(busIds[i]);
	}
	int count = this.routeService.deleteByVehicleNo(busIds);	
	if (count > 0) {
		msgMap.put("success", true);
		msgMap.put("msg", "ok");
	//	System.out.println(msgMap.isEmpty());
	} else if(count == 0 ){
		msgMap.put("success", false);
		msgMap.put("msg", "fail");
	}else if(count < 0) {
		msgMap.put("success", false);
		msgMap.put("msg", "repeat");
	}else{
		msgMap.put("success", false);
		msgMap.put("msg", "fail");
	}
	
	return "MSGMAP";
    }

    public String update() {
    	msgMap = new HashMap<>();
    	Gson gson = new Gson();
    	RouteBean routeBean=gson.fromJson(jsonData, RouteBean.class);
    	System.out.println(jsonData);
    	if(ValidationUtil.isNullOrEmpty(routeBean)){
    		msgMap.put("success", true);
    		msgMap.put("msg", "fail");
    		return "MSGMAP";
    	}
    	int count = this.routeService.update(routeBean);	
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
	this.setRouteList(this.routeService.findAll());
	return LIST;
    }
    
    public String getByVehicleNo(){
    	String vehicleno=routeBean.getVehicleno();
   //	setRouteBean(routeService.findByVehicleNo(vehicleno));
    	dataMap = new HashMap<>();
    	if (!ValidationUtil.isNullOrEmpty(routeBean)){
    		dataMap.put("success", true);
    		
    		dataMap.put("data", routeService.findByVehicleNo(vehicleno));
    	}else{
    		dataMap.put("success", false);
    	}
    	return "BUSBEAN";
    }

}
