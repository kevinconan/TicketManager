package kevin.tm.action;

import kevin.tm.dao.RouteMapper;
import kevin.tm.model.Route;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("request")
@Controller("testAction")
public class TestAction extends BaseAction<Object> {

	private RouteMapper routeMapper;
	public RouteMapper getRouteMapper() {
		return routeMapper;
	}

	public void setRouteMapper(RouteMapper routeMapper) {
		this.routeMapper = routeMapper;
	}

	private Route route;

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	
	public String route(){
		System.out.println(routeMapper.getById(1).getEndStation().getStationname());
		setRoute(routeMapper.getById(1));
		return MESSAGE;
	}
}

