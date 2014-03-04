package kevin.tm.service;



import java.util.List;

import kevin.tm.dao.model.BusBean;
import kevin.tm.model.BusBeanExt;

import org.springframework.stereotype.Service;

@Service
public interface BusService {
	public int save(BusBean busBean);
	public int deleteByVehicleNo(String vehicleNo);
	public int update(BusBean busBean);
	public List<BusBeanExt> findAll();
	public BusBean findByVehicleNo(String vehicleNo);

}
