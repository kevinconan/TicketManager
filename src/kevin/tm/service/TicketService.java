/**
 * 
 */
package kevin.tm.service;

import java.util.List;

import kevin.tm.model.TicketBean;

/**
 * 车票Service接口
 * 
 * @author Diluka
 * 
 */
public interface TicketService {
    public int save(TicketBean ticketBean);

    public int deleteById(Integer ticketId);

    public int update(TicketBean ticketBean);

    public TicketBean findById(Integer ticketId);

    public List<TicketBean> findAll();
}
