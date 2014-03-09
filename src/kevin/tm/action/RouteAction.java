/**
 * 
 */
package kevin.tm.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kevin.tm.dao.model.RouteBean;
import kevin.tm.service.RouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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
    private static final long serialVersionUID = 6226514656114785316L;

    @Autowired
    private RouteService routeService;

    private String createRouteBeans;
    private String updateRouteBeans;
    private String deleteRouteBeans;

    public String add() {
	List<Integer> list = new ArrayList<>();
	RouteBean[] beans = GSON.fromJson(this.createRouteBeans,
		RouteBean[].class);

	for (RouteBean bean : beans) {
	    if (this.routeService.save(bean) == 0) {
		list.add(bean.getRouteid());
	    }
	}

	this.map = new HashMap<String, Object>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(ERRORS, list);
	return MAP;
    }

    public String update() {
	List<Integer> list = new ArrayList<>();
	RouteBean[] beans = GSON.fromJson(this.updateRouteBeans,
		RouteBean[].class);

	for (RouteBean bean : beans) {
	    if (this.routeService.update(bean) == 0) {
		list.add(bean.getRouteid());
	    }
	}

	this.map = new HashMap<String, Object>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(ERRORS, list);
	return MAP;
    }

    public String delete() {
	List<Integer> list = new ArrayList<>();
	RouteBean[] beans = GSON.fromJson(this.deleteRouteBeans,
		RouteBean[].class);

	for (RouteBean bean : beans) {
	    if (this.routeService.delete(bean) == 0) {
		list.add(bean.getRouteid());
	    }
	}

	this.map = new HashMap<String, Object>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(ERRORS, list);
	return MAP;
    }

    public String list() {
	this.list = this.routeService.findByPage(this.start, this.limit);

	this.map = new HashMap<>();
	this.map.put(TOTAL_COUNT, this.routeService.totalCount());
	this.map.put(DATA, this.list);
	return MAP;
    }

    public String listAll() {
	this.list = this.routeService.findAll();
	return LIST;
    }

    public String getById() {
	this.list = new ArrayList<>();
	Object[] objects = GSON.fromJson(this.message, Object[].class);
	for (Object object : objects) {
	    this.list.add(this.routeService.findById((int) Double
		    .parseDouble(object.toString())));
	}

	this.map = new HashMap<>();
	this.map.put(SUCCESS, true);
	this.map.put(DATA, this.list);
	return MAP;
    }

    public String getCreateRouteBeans() {
	return this.createRouteBeans;
    }

    public void setCreateRouteBeans(String createRouteBeans) {
	this.createRouteBeans = createRouteBeans;
    }

    public String getUpdateRouteBeans() {
	return this.updateRouteBeans;
    }

    public void setUpdateRouteBeans(String updateRouteBeans) {
	this.updateRouteBeans = updateRouteBeans;
    }

    public String getDeleteRouteBeans() {
	return this.deleteRouteBeans;
    }

    public void setDeleteRouteBeans(String deleteRouteBeans) {
	this.deleteRouteBeans = deleteRouteBeans;
    }
}
