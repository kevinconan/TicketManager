package kevin.tm.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kevin.tm.dao.model.StationBean;

public interface StationBeanExtMapper {
	@Select("select stationname from station where stationname like '%#{stationName}%'")
	public List<StationBean> findByName(@Param("stationName")String stationName);
}
