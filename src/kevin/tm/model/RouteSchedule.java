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
    private Route scheduleRoute;

    public Route getScheduleRoute() {
	return this.scheduleRoute;
    }

    public void setScheduleRoute(Route scheduleRoute) {
	this.scheduleRoute = scheduleRoute;
    }
}
