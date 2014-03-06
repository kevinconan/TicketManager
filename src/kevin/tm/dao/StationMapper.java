/**
 * 
 */
package kevin.tm.dao;

import java.util.List;

import kevin.tm.model.Station;

import org.apache.ibatis.annotations.Param;

/**
 * @author Diluka
 * 
 */
public interface StationMapper {
    public Station getById(@Param("StationId") Integer stationId);

    public List<Station> getAll();

    public List<Station> getByName(@Param("StationName") String stationName);
}
