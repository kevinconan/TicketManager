/**
 * 
 */
package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.BusBeanMapper;
import kevin.tm.dao.model.BusBean;
import kevin.tm.dao.model.BusBeanExample;
import kevin.tm.service.BusService;

import org.apache.ibatis.session.RowBounds;
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

    // @Override
    // public int deleteByVehicleNo(String vehicleNo) {
    // return this.busBeanMapper.deleteByPrimaryKey(vehicleNo);
    // }

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
	BusBeanExample busBeanExample = new BusBeanExample();
	busBeanExample.clear();
	busBeanExample.createCriteria().andVehiclenoEqualTo(vehicleNo);
	List<BusBean> list = this.busBeanMapper.selectByExample(busBeanExample);
	return list.size() > 0 ? list.get(0) : null;
    }
    
    public BusBean findByBusId(int busId) {
    	BusBeanExample busBeanExample = new BusBeanExample();
    	busBeanExample.clear();
    	busBeanExample.createCriteria().andBusidEqualTo(busId);
    	List<BusBean> list = this.busBeanMapper.selectByExample(busBeanExample);
    	return list.size() > 0 ? list.get(0) : null;
        }


    // @Override
    // public int deleteByVehicleNo(String[] vehicleNo) {
    // if (vehicleNo.length > 0) {
    // int count = 0;
    // for (int i = 0; i < vehicleNo.length; i++) {
    // count += this.busBeanMapper.deleteByPrimaryKey(vehicleNo[i]);
    // }
    //
    // return count;
    // }
    // return 0;
    // }

    @Override
    public int totalCount() {
	BusBeanExample busBeanExample = new BusBeanExample();
	busBeanExample.clear();
	busBeanExample.createCriteria().getAllCriteria();
	return this.busBeanMapper.countByExample(busBeanExample);
    }

    @Override
    public List<BusBean> findByPage(int start, int limit) {
	return this.busBeanMapper.selectByPage(new RowBounds(start, limit));
    }

    @Override
    public int delete(BusBean busBean) {
	return this.busBeanMapper.deleteByPrimaryKey(busBean.getBusid());
    }

	@Override
	public boolean isVehicleNoExist(String vehicleno) {
		BusBeanExample example = new BusBeanExample();
		example.clear();
		example.createCriteria().andVehiclenoLike(vehicleno);
		if(busBeanMapper.countByExample(example)>0)
			return true;
		else
		    return false; 
	}

}
