package kevin.tm.service;



import java.util.List;

import kevin.tm.dao.model.BusBean;

import org.springframework.stereotype.Service;

@Service
public interface BusService {
	public int save(BusBean busBean);
	public int deleteByVehicleNo(String vehicleNo);
	public int update(BusBean busBean);
	public List<BusBean> findAll();
	public BusBean findByVehicleNo(String vehicleNo);

}
