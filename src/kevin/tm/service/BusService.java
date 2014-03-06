package kevin.tm.service;

import java.util.List;

import kevin.tm.dao.model.BusBean;
import kevin.tm.model.Bus;

import org.springframework.stereotype.Service;

@Service
public interface BusService {
    public int save(BusBean busBean);

    public int deleteByVehicleNo(String vehicleNo);

    public int deleteByVehicleNo(String[] vehivleNo);

    public int update(BusBean busBean);

    public List<Bus> findAll();

    public Bus findByVehicleNo(String vehicleNo);

    public int count();

}
