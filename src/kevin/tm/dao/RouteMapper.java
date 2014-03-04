/**
 * 
 */
package kevin.tm.dao;

import kevin.tm.model.Route;

import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 * 
 */
public interface RouteMapper {

    public Route getById(@Param("RouteId") Integer RouteId);

}
