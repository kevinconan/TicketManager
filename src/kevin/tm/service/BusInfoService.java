/**
 * 
 */
package kevin.tm.service;

import java.util.List;

import kevin.tm.dao.model.Businfo;

import org.springframework.stereotype.Service;

/**
 * @author Diluka
 * 
 */
@Service
public interface BusInfoService {
    int totalCount();

    List<Businfo> findByPage(int start, int limit);
}
