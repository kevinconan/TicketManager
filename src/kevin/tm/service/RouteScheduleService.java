/**
 * 
 */
package kevin.tm.service;

import java.util.List;

import kevin.tm.model.RouteScheduleBean;

/**
 * 线路日程Service接口
 * 
 * @author Diluka
 * 
 */
public interface RouteScheduleService {
    public int save(RouteScheduleBean routeScheduleBean);

    public int deleteById(Integer scheduleId);

    public int update(RouteScheduleBean routeScheduleBean);

    public RouteScheduleBean findById(Integer scheduleId);

    public List<RouteScheduleBean> findAll();
}
