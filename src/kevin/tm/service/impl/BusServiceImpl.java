/**
 * 
 */
package kevin.tm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import kevin.tm.dao.BusBeanMapper;
import kevin.tm.model.BusBean;
import kevin.tm.model.BusBeanExample;
import kevin.tm.service.BusService;

/**
 * 
 * @author Kevin
 *
 */
@Scope("prototype")
@Service("busServiceImpl")
public class BusServiceImpl implements BusService{

	@Autowired
	private BusBeanMapper busBeanMapper;
	
	public BusBeanMapper getBusBeanMapper() {
		return busBeanMapper;
	}

	public void setBusBeanMapper(BusBeanMapper busBeanMapper) {
		this.busBeanMapper = busBeanMapper;
	}

	@Override
	public int save(BusBean busBean) {
		return busBeanMapper.insert(busBean);
	}

	@Override
	public int deleteByVehicleNo(String vehicleNo) {
		return busBeanMapper.deleteByPrimaryKey(vehicleNo);
	}

	@Override
	public int update(BusBean busBean) {

		return busBeanMapper.updateByPrimaryKey(busBean);
	}

	@Override
	public List<BusBean> findAll() {
		BusBeanExample example = new BusBeanExample();
		example.clear();
		example.createCriteria().getAllCriteria();
		return busBeanMapper.selectByExample(example);
	}

	@Override
	public BusBean findByVehicleNo(String vehicleNo) {
		
		return busBeanMapper.selectByPrimaryKey(vehicleNo);
	}

}
