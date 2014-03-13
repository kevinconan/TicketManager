/**
 * 
 */
package kevin.tm.service;

import java.util.Date;
import java.util.List;

import kevin.tm.dao.model.Ticketinfo;

import org.springframework.stereotype.Service;

/**
 * @author Diluka
 * 
 */
@Service
public interface TicketInfoService {
    int totalCount();

    List<Ticketinfo> findByPage(int start, int limit);

    List<Ticketinfo> findByScheduleid(Integer scheduleid, int start, int limit);

    List<Ticketinfo> findByCustomer(String name, int start, int limit);

    List<Ticketinfo> findByStarttime(Date date, boolean isPast, int start,
	    int limit);

    List<Ticketinfo> findByStarttime(Date begin, Date untill, int start,
	    int limit);

    List<Ticketinfo> findByEndtime(Date date, boolean isPast, int start,
	    int limit);

    List<Ticketinfo> findByEndtime(Date begin, Date untill, int start, int limit);

    List<Ticketinfo> findByRoutename(String routename, Date begin, Date untill,
	    int start, int limit);

    List<Ticketinfo> findByRoutename(String routename, int start, int limit);

    List<Ticketinfo> findByRouteid(Integer routeid, Date begin, Date untill,
	    int start, int limit);

    List<Ticketinfo> findByRouteid(Integer routeid, int start, int limit);

    int countByScheduleid(Integer scheduleid);

}
