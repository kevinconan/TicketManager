/**
 *
 */
package kevin.tm.service;

import java.util.List;
import kevin.tm.dao.model.Scheduleinfo;
import org.springframework.stereotype.Service;

/**
 * @author Diluka
 *
 */
@Service
public interface ScheduleInfoService {

    public int totalCount();

    public List<Scheduleinfo> findByPage(int start, int limit);
}
