/**
 * 
 */
package kevin.tm.dao;

import java.util.List;

import kevin.tm.model.Bus;

import org.apache.ibatis.annotations.Param;

/**
 * @author Diluka
 * 
 */
public interface BusMapper {
    public Bus getById(@Param("VehicleNo") String vehicleNo);

    public List<Bus> getAll();
}
