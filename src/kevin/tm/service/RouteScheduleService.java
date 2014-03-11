/**
 * 
 */
package kevin.tm.service;

import java.util.List;

import kevin.tm.dao.model.RouteScheduleBean;

import org.springframework.stereotype.Service;

/**
 * 线路日程Service接口
 * 
 * @author Diluka
 * 
 */
@Service
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
     * 删除
     * 
     * @param routeScheduleBean
     * @return
     */
    public int delete(RouteScheduleBean routeScheduleBean);

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
    public RouteScheduleBean findById(Integer scheduleId);

    /**
     * 查找全部
     * 
     * @return
     */
    public List<RouteScheduleBean> findAll();

    public int totalCount();

    public List<RouteScheduleBean> findByPage(int start, int limit);
}
