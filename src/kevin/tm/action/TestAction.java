package kevin.tm.action;

import java.util.List;

import kevin.tm.dao.RouteBeanMapper;
import kevin.tm.dao.RouteMapper;
import kevin.tm.dao.ext.BusBeanExtMapper;
import kevin.tm.model.BusBeanExt;
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

    private List<BusBeanExt> busList;

    public List<BusBeanExt> getBusList() {
	return this.busList;
    }

    public void setBusList(List<BusBeanExt> busList) {
	this.busList = busList;
    }

    @Autowired
    private BusBeanExtMapper busBeanExtMapper;

    public String route() {
	try {

	    // System.out.println(routeMapper.getById(1).getEndStation().getStationname());
	    // RouteBean routeBean = this.routeBeanMapper.selectByPrimaryKey(1);
	    // System.out.println(routeBean);
	    this.route = this.routeMapper.getById(1);
	    // System.out.println(this.route);
	    this.busList = this.busBeanExtMapper.getAllBusBeanExts();
	    System.out.println(this.route.getRoutename());
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
