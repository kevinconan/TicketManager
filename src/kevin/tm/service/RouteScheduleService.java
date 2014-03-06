/**
 * 
 */
package kevin.tm.service;

import java.util.List;

import kevin.tm.dao.model.RouteScheduleBean;
import kevin.tm.model.RouteSchedule;

/**
 * 线路日程Service接口
 * 
 * @author Diluka
 * 
 */
public interface RouteScheduleService {
    /**
     * 保存
     * 
     * @param routeScheduleBean
     * @return
     */
    public int save(RouteScheduleBean routeScheduleBean);

    /**
     * ID删除
     * 
     * @param scheduleId
     * @return
     */
    public int deleteById(Integer scheduleId);

    /**
     * 修改
     * 
     * @param routeScheduleBean
     * @return
     */
    public int update(RouteScheduleBean routeScheduleBean);

    /**
     * ID查找
     * 
     * @param scheduleId
     * @return
     */
    public RouteSchedule findById(Integer scheduleId);

    /**
     * 查找全部
     * 
     * @return
     */
    public List<RouteSchedule> findAll();

    public int count();
}
