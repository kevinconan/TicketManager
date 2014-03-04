package kevin.tm.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kevin.tm.model.BusBeanExt;

public interface BusBeanExtMapper {
	
	/**
	 * 查询车辆扩展信息
	 * @author Kevin
	 * */
	@Select("select VehicleNo,DriverName,SeatCount,SeatCount,BusState,BusStationId,BusRouteId,StationName,RouteName " +
			"from [dbo].[Bus],[dbo].[Route],[dbo].[station] " +
			"where BusStationId=StationId and BusRouteId=RouteId")
	public List<BusBeanExt> getAllBusBeanExts();
	

}
