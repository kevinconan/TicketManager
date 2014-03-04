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

    private RouteSchedule ticketSchedule;

    public RouteSchedule getTicketSchedule() {
	return this.ticketSchedule;
    }

    public void setTicketSchedule(RouteSchedule ticketSchedule) {
	this.ticketSchedule = ticketSchedule;
    }
}
