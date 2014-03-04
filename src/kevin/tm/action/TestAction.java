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
	return this.routeMapper;
    }

    public void setRouteMapper(RouteMapper routeMapper) {
	this.routeMapper = routeMapper;
    }

    public String route() {
	// System.out.println(routeMapper.getById(1).getEndStation().getStationname());
	try {
	    Route route = this.routeMapper.getById(1);
	    System.out.println(route);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return MESSAGE;
    }
}
