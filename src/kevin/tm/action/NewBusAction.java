/**
 * 
 */
package kevin.tm.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kevin.tm.dao.model.BusBean;
import kevin.tm.service.BusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Diluka
 * 
 */
@Scope("request")
@Controller("newBusAction")
public class NewBusAction extends BaseAction<BusBean> {

    @Autowired
    private BusService busService;

    private String createBusBeans;
    private String updateBusBeans;
    private String deleteBusBeans;

    public String add() {
	List<Integer> list = new ArrayList<>();
	BusBean[] beans = GSON.fromJson(this.createBusBeans, BusBean[].class);

	for (BusBean bean : beans) {
	    if (this.busService.save(bean) == 0) {
		list.add(bean.getVehicleno());
	    }
	}

	this.map = new HashMap<String, Object>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(ERRORS, list);
	return MAP;
    }

    public String update() {
	List<Integer> list = new ArrayList<>();
	BusBean[] beans = GSON.fromJson(this.updateBusBeans, BusBean[].class);

	for (BusBean bean : beans) {
	    if (this.busService.update(bean) == 0) {
		list.add(bean.getVehicleno());
	    }
	}

	this.map = new HashMap<String, Object>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(ERRORS, list);
	return MAP;
    }

    public String delete() {
	List<Integer> list = new ArrayList<>();
	BusBean[] beans = GSON.fromJson(this.deleteBusBeans, BusBean[].class);

	for (BusBean bean : beans) {
	    if (this.busService.delete(bean) == 0) {
		list.add(bean.getVehicleno());
	    }
	}

	this.map = new HashMap<String, Object>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(ERRORS, list);
	return MAP;
    }

    public String list() {
	this.list = this.busService.findByPage(this.start, this.limit);

	this.map = new HashMap<>();
	this.map.put(TOTAL_COUNT, this.busService.totalCount());
	this.map.put(DATA, this.list);
	return MAP;
    }

    public String listAll() {
	this.list = this.busService.findAll();
	return LIST;
    }

    public String getById() {
	this.list = new ArrayList<>();
	Object[] objects = GSON.fromJson(this.message, Object[].class);
	for (Object object : objects) {
	    this.list.add(this.busService.findById((int) Double
		    .parseDouble(object.toString())));
	}

	this.map = new HashMap<>();
	this.map.put(DATA, this.list);
	return MAP;
    }

    public String getCreateBusBeans() {
	return this.createBusBeans;
    }

    public void setCreateBusBeans(String createBusBeans) {
	this.createBusBeans = createBusBeans;
    }

    public String getUpdateBusBeans() {
	return this.updateBusBeans;
    }

    public void setUpdateBusBeans(String updateBusBeans) {
	this.updateBusBeans = updateBusBeans;
    }

    public String getDeleteBusBeans() {
	return this.deleteBusBeans;
    }

    public void setDeleteBusBeans(String deleteBusBeans) {
	this.deleteBusBeans = deleteBusBeans;
    }
}
