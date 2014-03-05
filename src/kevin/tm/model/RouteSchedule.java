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
    private Bus schedulebus;

    public Bus getSchedulebus() {
	return this.schedulebus;
    }

    public void setSchedulebus(Bus schedulebus) {
	this.schedulebus = schedulebus;
    }

    public Route getScheduleroute() {
	return this.scheduleroute;
    }

    public void setScheduleroute(Route scheduleRoute) {
	this.scheduleroute = scheduleRoute;
    }
}
