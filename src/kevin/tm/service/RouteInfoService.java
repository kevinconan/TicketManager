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
    int totalCount();

    List<Routeinfo> findByPage(int start, int limit);
}
