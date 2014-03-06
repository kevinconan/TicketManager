/**
 * 
 */
package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.BusBeanMapper;
import kevin.tm.dao.model.BusBean;
import kevin.tm.dao.model.BusBeanExample;
import kevin.tm.service.BusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Kevin
 * 
 */
@Scope("prototype")
@Service("busServiceImpl")
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
	BusBeanExample example = new BusBeanExample();
	example.clear();
	example.createCriteria().andVehiclenoEqualTo(busBean.getVehicleno());
	// 判断如果主键重复则返回-1
	if (this.busBeanMapper.countByExample(example) > 0) {
	    return -1;
	}
	return this.busBeanMapper.insert(busBean);
    }

    @Override
    public int deleteByVehicleNo(String vehicleNo) {
	return this.busBeanMapper.deleteByPrimaryKey(vehicleNo);
    }

    @Override
    public int update(BusBean busBean) {

	return this.busBeanMapper.updateByPrimaryKeySelective(busBean);
    }

    @Override
    public List<BusBean> findAll() {
	BusBeanExample busBeanExample = new BusBeanExample();
	busBeanExample.clear();
	busBeanExample.createCriteria().getAllCriteria();
	return this.busBeanMapper.selectByExample(busBeanExample);
    }

    @Override
    public BusBean findByVehicleNo(String vehicleNo) {

	return this.busBeanMapper.selectByPrimaryKey(vehicleNo);
    }

    @Override
    public int deleteByVehicleNo(String[] vehicleNo) {
	if (vehicleNo.length > 0) {
	    int count = 0;
	    for (int i = 0; i < vehicleNo.length; i++) {
		count += this.busBeanMapper.deleteByPrimaryKey(vehicleNo[i]);
	    }

	    return count;
	}
	return 0;
    }

    @Override
    public int totalCount() {
	BusBeanExample busBeanExample = new BusBeanExample();
	busBeanExample.clear();
	busBeanExample.createCriteria().getAllCriteria();
	return this.busBeanMapper.countByExample(busBeanExample);
    }

}
