/**
 * 
 */
package kevin.tm.model;

import kevin.tm.dao.model.RouteScheduleBean;

/**
 * 行程实体
 * 
 * @author Diluka
 * 
 */
public class RouteSchedule extends RouteScheduleBean {
    private Route scheduleroute;

    public Route getScheduleroute() {
	return this.scheduleroute;
    }

    public void setScheduleroute(Route scheduleRoute) {
	this.scheduleroute = scheduleRoute;
    }
}
