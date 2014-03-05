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
    private Station busstation;
    private Route busroute;

    public Station getBusstation() {
	return this.busstation;
    }

    public void setBusstation(Station busStation) {
	this.busstation = busStation;
    }

    public Route getBusroute() {
	return this.busroute;
    }

    public void setBusroute(Route busRoute) {
	this.busroute = busRoute;
    }
}
