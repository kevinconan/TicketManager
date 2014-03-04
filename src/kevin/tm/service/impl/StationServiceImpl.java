/**
 * 
 */
package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.StationBeanMapper;
import kevin.tm.dao.model.StationBean;
import kevin.tm.dao.model.StationBeanExample;
import kevin.tm.service.StationService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Diluka
 * 
 */
public class StationServiceImpl implements StationService {

    @Autowired
    private StationBeanMapper stationBeanMapper;

    public StationBeanMapper getStationBeanMapper() {
	return this.stationBeanMapper;
    }

    public void setStationBeanMapper(StationBeanMapper stationBeanMapper) {
	this.stationBeanMapper = stationBeanMapper;
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.StationService#save(kevin.tm.dao.model.StationBean)
     */
    @Override
    public int save(StationBean stationBean) {
	return this.stationBeanMapper.insert(stationBean);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.StationService#deleteById(int)
     */
    @Override
    public int deleteById(Integer stationId) {
	return this.stationBeanMapper.deleteByPrimaryKey(stationId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.StationService#update(kevin.tm.dao.model.StationBean)
     */
    @Override
    public int update(StationBean stationBean) {
	return this.stationBeanMapper.updateByPrimaryKey(stationBean);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.StationService#findById(int)
     */
    @Override
    public StationBean findById(Integer stationId) {
	return this.stationBeanMapper.selectByPrimaryKey(stationId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.StationService#findAll()
     */
    @Override
    public List<StationBean> findAll() {
	StationBeanExample stationBeanExample = new StationBeanExample();
	stationBeanExample.clear();
	stationBeanExample.createCriteria().getAllCriteria();
	return this.stationBeanMapper.selectByExample(stationBeanExample);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.StationService#findByName(java.lang.String)
     */
    @Override
    public List<StationBean> findByName(String stationName) {
	StationBeanExample stationBeanExample = new StationBeanExample();
	stationBeanExample.clear();
	stationBeanExample.createCriteria().andStationnameLike(stationName);
	return this.stationBeanMapper.selectByExample(stationBeanExample);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.StationService#calcTowStationDistanceById(int, int)
     */
    @Override
    public Double calcTowStationDistanceById(Integer stationA, Integer stationB) {
	// TODO Auto-generated method stub
	return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * kevin.tm.service.StationService#calcTowStationDistance(kevin.tm.dao.model
     * .StationBean, kevin.tm.dao.model.StationBean)
     */
    @Override
    public Double calcTowStationDistance(StationBean stationA,
	    StationBean stationB) {
	// TODO Auto-generated method stub
	return null;
    }

}
