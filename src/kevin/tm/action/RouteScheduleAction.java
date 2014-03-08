/**
 * 
 */
package kevin.tm.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kevin.tm.dao.model.RouteScheduleBean;
import kevin.tm.service.RouteScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Diluka
 * 
 */
@Scope("request")
@Controller("routeScheduleAction")
public class RouteScheduleAction extends BaseAction<RouteScheduleBean> {
    /**
     * 
     */
    private static final long serialVersionUID = 2250890878922010360L;

    @Autowired
    private RouteScheduleService routeScheduleService;

    private String createRouteScheduleBeans;
    private String updateRouteScheduleBeans;
    private String deleteRouteScheduleBeans;

    public String add() {
	List<Integer> list = new ArrayList<>();
	RouteScheduleBean[] beans = GSON.fromJson(
		this.createRouteScheduleBeans, RouteScheduleBean[].class);

	for (RouteScheduleBean bean : beans) {
	    if (this.routeScheduleService.save(bean) == 0) {
		list.add(bean.getScheduleid());
	    }
	}

	this.map = new HashMap<String, Object>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(FAILURE, list);
	return MAP;
    }

    public String update() {
	List<Integer> list = new ArrayList<>();
	RouteScheduleBean[] beans = GSON.fromJson(
		this.updateRouteScheduleBeans, RouteScheduleBean[].class);

	for (RouteScheduleBean bean : beans) {
	    if (this.routeScheduleService.update(bean) == 0) {
		list.add(bean.getScheduleid());
	    }
	}

	this.map = new HashMap<String, Object>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(FAILURE, list);
	return MAP;
    }

    public String delete() {
	List<Integer> list = new ArrayList<>();
	RouteScheduleBean[] beans = GSON.fromJson(
		this.deleteRouteScheduleBeans, RouteScheduleBean[].class);

	for (RouteScheduleBean bean : beans) {
	    if (this.routeScheduleService.delete(bean) == 0) {
		list.add(bean.getScheduleid());
	    }
	}

	this.map = new HashMap<String, Object>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(FAILURE, list);
	return MAP;
    }

    public String list() {
	this.list = this.routeScheduleService
		.findByPage(this.start, this.limit);

	this.map = new HashMap<>();
	this.map.put(TOTAL_COUNT, this.routeScheduleService.totalCount());
	this.map.put(ROWS, this.list);
	return MAP;
    }

    public String getById() {
	this.message = GSON.toJson(this.routeScheduleService.findById(Integer
		.getInteger(this.message)));
	return MESSAGE;
    }

    public String getCreateRouteScheduleBeans() {
	return this.createRouteScheduleBeans;
    }

    public void setCreateRouteScheduleBeans(String createRouteScheduleBeans) {
	this.createRouteScheduleBeans = createRouteScheduleBeans;
    }

    public String getUpdateRouteScheduleBeans() {
	return this.updateRouteScheduleBeans;
    }

    public void setUpdateRouteScheduleBeans(String updateRouteScheduleBeans) {
	this.updateRouteScheduleBeans = updateRouteScheduleBeans;
    }

    public String getDeleteRouteScheduleBeans() {
	return this.deleteRouteScheduleBeans;
    }

    public void setDeleteRouteScheduleBeans(String deleteRouteScheduleBeans) {
	this.deleteRouteScheduleBeans = deleteRouteScheduleBeans;
    }
}
