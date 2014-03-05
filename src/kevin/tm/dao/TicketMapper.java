/**
 * 
 */
package kevin.tm.dao;

import java.util.List;

import kevin.tm.model.Ticket;

import org.apache.ibatis.annotations.Param;

/**
 * @author Diluka
 * 
 */
public interface TicketMapper {
    public Ticket getById(@Param("TicketId") Integer ticketId);

    public List<Ticket> getAll();
}
