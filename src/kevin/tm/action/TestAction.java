package kevin.tm.action;

import kevin.tm.dao.RouteBeanMapper;
import kevin.tm.dao.RouteMapper;
import kevin.tm.model.Route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("request")
@Controller("testAction")
public class TestAction extends BaseAction<Object> {

    @Autowired
    private RouteMapper routeMapper;

    @Autowired
    private RouteBeanMapper routeBeanMapper;

    private Route route;

    public String route() {
	try {

	    // System.out.println(routeMapper.getById(1).getEndStation().getStationname());
	    // RouteBean routeBean = this.routeBeanMapper.selectByPrimaryKey(1);
	    // System.out.println(routeBean);
	    this.route = this.routeMapper.getById(1);
	    System.out.println(this.route);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return MESSAGE;
    }

    public Route getRoute() {
	return this.route;
    }

    public void setRoute(Route route) {
	this.route = route;
    }
}
