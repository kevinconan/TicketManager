package kevin.tm.service;

import java.util.List;

import kevin.tm.dao.model.BusBean;

import org.springframework.stereotype.Service;

@Service
public interface BusService {
    public int save(BusBean busBean);

    public int delete(BusBean busBean);

    // public int deleteByVehicleNo(String vehicleNo);
    //
    // public int deleteByVehicleNo(String[] vehivleNo);

    public int update(BusBean busBean);

    public List<BusBean> findAll();

    public BusBean findByVehicleNo(String vehicleNo);

    public int totalCount();

    public List<BusBean> findByPage(int start, int limit);
}
