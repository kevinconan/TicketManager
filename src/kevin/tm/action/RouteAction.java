/**
 * 
 */
package kevin.tm.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kevin.tm.model.Route;

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
public class RouteAction extends BaseAction<Route> {

    /**
     * 
     */
    private static final long serialVersionUID = 7467813069003588100L;
    private List<Route> routeList;
    
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

	public Route getRoute() {
		return routeBean;
	}

	public void setRoute(Route routeBean) {
		this.routeBean = routeBean;
	}

	private Route routeBean;

    public List<Route> getRouteList() {
	return this.routeList;
    }

    public void setRouteList(List<Route> routeList) {
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
    	Route routeBean=gson.fromJson(jsonData, Route.class);
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
	Gson gson = new Gson();
	int[] routeIds = gson.fromJson(jsonData, int[].class);

	for (int i = 0; i < routeIds.length; i++) {
		System.out.println(routeIds[i]);
	}
	int count = this.routeService.deleteById(routeIds);	
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
    	Route routeBean=gson.fromJson(jsonData, Route.class);
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
    
    public String getById(){
    	int vehicleno=routeBean.getRouteid();
   //	setRoute(routeService.findByVehicleNo(vehicleno));
    	dataMap = new HashMap<>();
    	if (!ValidationUtil.isNullOrEmpty(routeBean)){
    		dataMap.put("success", true);
    		
    		dataMap.put("data", routeService.findById(vehicleno));
    	}else{
    		dataMap.put("success", false);
    	}
    	return "BUSBEAN";
    }

}
