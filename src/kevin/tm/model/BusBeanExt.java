/**
 * 
 */
package kevin.tm.model;

import kevin.tm.dao.model.BusBean;

/**
 * 汽车信息扩展类
 * @author Kevin
 *
 */
public class BusBeanExt extends BusBean {

	private String routename;
	public String getRoutename() {
		return routename;
	}
	public void setRouteName(String routename) {
		this.routename = routename;
	}
	public String getStationname() {
		return stationname;
	}
	public void setStationname(String stationname) {
		this.stationname = stationname;
	}
	private String stationname;
	
}
