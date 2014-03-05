/**
 * 
 */
package kevin.tm.dao;

import java.util.List;

import kevin.tm.model.RouteSchedule;

import org.apache.ibatis.annotations.Param;

/**
 * @author Diluka
 * 
 */
public interface RouteScheduleMapper {
    public RouteSchedule getById(@Param("ScheduleId") Integer scheduleId);

    public List<RouteSchedule> getAll();

}
