/**
 * 
 */
package kevin.tm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import kevin.tm.model.BusBeanExt;
import kevin.tm.dao.BusBeanMapper;
import kevin.tm.dao.ext.BusBeanExtMapper;
import kevin.tm.dao.model.BusBean;
import kevin.tm.dao.model.BusBeanExample;

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
	private BusBeanExtMapper busBeanExtMapper;
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
	public List<BusBeanExt> findAll() {
		
		return busBeanExtMapper.getAllBusBeanExts();
	}

	@Override
	public BusBean findByVehicleNo(String vehicleNo) {
		
		return busBeanMapper.selectByPrimaryKey(vehicleNo);
	}

}
