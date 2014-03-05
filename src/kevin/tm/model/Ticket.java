/**
 * 
 */
package kevin.tm.model;

import kevin.tm.dao.model.TicketBean;

/**
 * 车票实体
 * 
 * @author Diluka
 * 
 */
public class Ticket extends TicketBean {

    private RouteSchedule ticketschedule;

    public RouteSchedule getTicketschedule() {
	return this.ticketschedule;
    }

    public void setTicketschedule(RouteSchedule ticketSchedule) {
	this.ticketschedule = ticketSchedule;
    }
}
