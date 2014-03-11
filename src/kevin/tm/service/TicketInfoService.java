/**
 * 
 */
package kevin.tm.service;

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
}
