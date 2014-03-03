/**
 * 
 */
package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.BusBeanMapper;
import kevin.tm.model.BusBean;
import kevin.tm.model.BusBeanExample;
import kevin.tm.service.BusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Kevin
 * 
 */
@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusBeanMapper busBeanMapper;

    public BusBeanMapper getBusBeanMapper() {
	return this.busBeanMapper;
    }

    public void setBusBeanMapper(BusBeanMapper busBeanMapper) {
	this.busBeanMapper = busBeanMapper;
    }

    @Override
    public int save(BusBean busBean) {
	return this.busBeanMapper.insert(busBean);
    }

    @Override
    public int deleteByVehicleNo(String vehicleNo) {
	return this.busBeanMapper.deleteByPrimaryKey(vehicleNo);
    }

    @Override
    public int update(BusBean busBean) {

	return this.busBeanMapper.updateByPrimaryKey(busBean);
    }

    @Override
    public List<BusBean> findAll() {
	BusBeanExample example = new BusBeanExample();
	example.clear();
	example.createCriteria().getAllCriteria();
	return this.busBeanMapper.selectByExample(example);
    }

    @Override
    public BusBean findByVehicleNo(String vehicleNo) {

	return this.busBeanMapper.selectByPrimaryKey(vehicleNo);
    }

}
