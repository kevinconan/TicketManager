/**
 * 
 */
package kevin.tm.service;

import java.util.List;

import kevin.tm.model.RouteBean;

/**
 * 路线Service接口
 * 
 * @author Diluka
 * 
 */
public interface RouteService {
    public int save(RouteBean routeBean);

    public int deleteById(Integer routeId);

    public int update(RouteBean routeBean);

    public RouteBean findById(Integer routeId);

    public List<RouteBean> findAll();
}
