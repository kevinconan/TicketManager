/**
 *
 */
package kevin.tm.service;

import java.util.Date;
import java.util.List;
import kevin.tm.dao.model.Ticketinfo;
import kevin.tm.dao.model.TicketinfoExample;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;

/**
 * @author Diluka
 *
 */
@Service
public interface TicketInfoService {

    public int totalCount();

    public List<Ticketinfo> findByPage(int start, int limit,JsonObject jsonObject);

    public List<Ticketinfo> findByScheduleid(Integer scheduleid, int start, int limit);

    public List<Ticketinfo> findByCustomer(String name, int start, int limit);

    public List<Ticketinfo> findByStarttime(Date date, boolean isPast, int start,
            int limit);

    public List<Ticketinfo> findByStarttime(Date begin, Date untill, int start,
            int limit);

    public List<Ticketinfo> findByEndtime(Date date, boolean isPast, int start,
            int limit);

    public List<Ticketinfo> findByEndtime(Date begin, Date untill, int start, int limit);

    public List<Ticketinfo> findByRoutename(String routename, Date begin, Date untill,
            int start, int limit);

    public List<Ticketinfo> findByRoutename(String routename, int start, int limit);

    public List<Ticketinfo> findByRouteid(Integer routeid, Date begin, Date untill,
            int start, int limit);

    public List<Ticketinfo> findByRouteid(Integer routeid, int start, int limit);

    public List<Ticketinfo> findByStation(String startStation, String endStation, int start, int limit);

    public List<Ticketinfo> findByStation(Integer startStation, Integer endStation, int start, int limit);

    public int countByStation(String startStation, String endStation);

    public int countByStation(Integer startStation, Integer endStation);

    public int countByScheduleid(Integer scheduleid);

    public int countByCustomer(String name);

    public int countByStarttime(Date date, boolean isPast);

    public int countByStarttime(Date begin, Date untill);

    public int countByEndtime(Date date, boolean isPast);

    public int countByEndtime(Date begin, Date untill);

    public int countByRoutename(String routename, Date begin, Date untill);

    public int countByRoutename(String routename);

    public int countByRouteid(Integer routeid, Date begin, Date untill);

    public int countByRouteid(Integer routeid);

    public List<Ticketinfo> findByExample(TicketinfoExample example, int start, int limit);

    public int countByExample(TicketinfoExample example);

}
