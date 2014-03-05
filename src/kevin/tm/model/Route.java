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
    protected Station startstation;
    protected Station endstation;

    public Station getStartstation() {
	return this.startstation;
    }

    public void setStartstation(Station startstation) {
	this.startstation = startstation;
    }

    public Station getEndstation() {
	return this.endstation;
    }

    public void setEndstation(Station endstation) {
	this.endstation = endstation;
    }
    //
    // @Override
    // public Integer getRouteid() {
    // return this.routeid;
    // }
    //
    // @Override
    // public void setRouteid(Integer routeid) {
    // this.routeid = routeid;
    // }
    //
    // @Override
    // public Integer getStartstationid() {
    // return this.startstationid;
    // }
    //
    // @Override
    // public void setStartstationid(Integer startstationid) {
    // this.startstationid = startstationid;
    // }
    //
    // @Override
    // public Integer getEndstationid() {
    // return this.endstationid;
    // }
    //
    // @Override
    // public void setEndstationid(Integer endstationid) {
    // this.endstationid = endstationid;
    // }
    //
    // @Override
    // public String getRoutename() {
    // return this.routename;
    // }
    //
    // @Override
    // public void setRoutename(String routename) {
    // this.routename = routename == null ? null : routename.trim();
    // }
}
