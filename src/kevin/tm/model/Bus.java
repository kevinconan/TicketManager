/**
 * 
 */
package kevin.tm.model;

import kevin.tm.dao.model.BusBean;

/**
 * 汽车实体
 * 
 * @author Diluka
 * 
 */
public class Bus extends BusBean {
    private Station busStation;
    private Route busRoute;

    public Station getBusStation() {
	return this.busStation;
    }

    public void setBusStation(Station buStation) {
	this.busStation = buStation;
    }

    public Route getBusRoute() {
	return this.busRoute;
    }

    public void setBusRoute(Route busRoute) {
	this.busRoute = busRoute;
    }
}
