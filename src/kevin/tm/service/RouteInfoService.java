/**
 *
 */
package kevin.tm.service;

import java.util.List;
import kevin.tm.dao.model.Routeinfo;
import org.springframework.stereotype.Service;

/**
 * @author Diluka
 *
 */
@Service
public interface RouteInfoService {

    public int totalCount();

    public List<Routeinfo> findByPage(int start, int limit);
}
