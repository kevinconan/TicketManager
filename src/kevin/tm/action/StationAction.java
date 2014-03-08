package kevin.tm.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kevin.tm.dao.model.StationBean;
import kevin.tm.service.StationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("request")
@Controller("stationAction")
public class StationAction extends BaseAction<StationBean> {

    /**
     * 
     */
    private static final long serialVersionUID = 1361215363387998977L;

    @Autowired
    private StationService stationService;

    private String createStationBeans;
    private String updateStationBeans;
    private String deleteStationBeans;

    public String add() {
	List<Integer> list = new ArrayList<>();
	StationBean[] beans = GSON.fromJson(this.createStationBeans,
		StationBean[].class);

	for (StationBean bean : beans) {
	    if (this.stationService.save(bean) == 0) {
		list.add(bean.getStationid());
	    }
	}

	this.map = new HashMap<String, Object>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(FAILURE, list);
	return MAP;
    }

    public String update() {
	List<Integer> list = new ArrayList<>();
	StationBean[] beans = GSON.fromJson(this.updateStationBeans,
		StationBean[].class);

	for (StationBean bean : beans) {
	    if (this.stationService.update(bean) == 0) {
		list.add(bean.getStationid());
	    }
	}

	this.map = new HashMap<String, Object>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(FAILURE, list);
	return MAP;
    }

    public String delete() {
	List<Integer> list = new ArrayList<>();
	StationBean[] beans = GSON.fromJson(this.deleteStationBeans,
		StationBean[].class);

	for (StationBean bean : beans) {
	    if (this.stationService.delete(bean) == 0) {
		list.add(bean.getStationid());
	    }
	}

	this.map = new HashMap<String, Object>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(FAILURE, list);
	return MAP;
    }

    public String list() {
	this.list = this.stationService.findByPage(this.start, this.limit);

	this.map = new HashMap<>();
	this.map.put(TOTAL_COUNT, this.stationService.totalCount());
	this.map.put(ROWS, this.list);
	return MAP;
    }

    public String getById() {
	this.list = new ArrayList<>();
	Object[] objects = GSON.fromJson(this.message, Object[].class);
	for (Object object : objects) {
	    this.list.add(this.stationService.findById((int) Double
		    .parseDouble(object.toString())));
	}

	this.map = new HashMap<>();
	this.map.put(ROWS, this.list);
	return MAP;
    }

    public String getCreateStationBeans() {
	return this.createStationBeans;
    }

    public void setCreateStationBeans(String createStationBeans) {
	this.createStationBeans = createStationBeans;
    }

    public String getUpdateStationBeans() {
	return this.updateStationBeans;
    }

    public void setUpdateStationBeans(String updateStationBeans) {
	this.updateStationBeans = updateStationBeans;
    }

    public String getDeleteStationBeans() {
	return this.deleteStationBeans;
    }

    public void setDeleteStationBeans(String deleteStationBeans) {
	this.deleteStationBeans = deleteStationBeans;
    }
}
