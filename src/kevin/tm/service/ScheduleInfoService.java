/**
 *
 */
package kevin.tm.service;

import java.util.List;
import kevin.tm.dao.model.Scheduleinfo;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;

/**
 * @author Diluka
 *
 */
@Service
public interface ScheduleInfoService {

    public int totalCount();

    public List<Scheduleinfo> findByPage(int start, int limit,JsonObject params);
    public Scheduleinfo findById(int scheduleid);
}
