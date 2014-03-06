/**
 * 
 */
package kevin.tm.dao;

import java.util.List;

import kevin.tm.model.Route;

import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 * 
 */
public interface RouteMapper {

    public Route getById(@Param("RouteId") Integer RouteId);

    public List<Route> getAll();

    public List<Route> getByName(@Param("RouteName") String routeName);
}
