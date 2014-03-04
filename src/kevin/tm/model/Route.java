/**
 * 
 */
package kevin.tm.model;

import kevin.tm.dao.model.RouteBean;

/**
 * 线路实体
 * 
 * @author Diluka
 * 
 */
public class Route extends RouteBean {
    private Station startStation;
    private Station endStation;

    public Station getStartStation() {
	return this.startStation;
    }

    public void setStartStation(Station startStation) {
	this.startStation = startStation;
    }

    public Station getEndStation() {
	return this.endStation;
    }

    public void setEndStation(Station endStation) {
	this.endStation = endStation;
    }

}
