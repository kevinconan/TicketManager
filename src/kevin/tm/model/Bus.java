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
    private Station buStation;
    private Route busRoute;

    public Station getBuStation() {
	return this.buStation;
    }

    public void setBuStation(Station buStation) {
	this.buStation = buStation;
    }

    public Route getBusRoute() {
	return this.busRoute;
    }

    public void setBusRoute(Route busRoute) {
	this.busRoute = busRoute;
    }
}
