package kevin.tm.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import kevin.tm.dao.model.RouteBean;
import kevin.tm.service.RouteService;
@Scope("request")
@Controller("routeAction")
public class RouteAction extends BaseAction<RouteBean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2483383245282315786L;

	@Autowired
	@Qualifier("routeServiceImpl")
	private RouteService routeService;
	
	private List<RouteBean> routeList;

	public RouteService getRouteService() {
		return routeService;
	}

	public void setRouteService(RouteService routeService) {
		this.routeService = routeService;
	}

	public List<RouteBean> getRouteList() {
		return routeList;
	}

	public void setRouteList(List<RouteBean> routeList) {
		this.routeList = routeList;
	}
	
	public String list(){
		setRouteList(routeService.findAll());
		return LIST;
	}
}
