/**
 * 
 */
package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.StationBeanMapper;
import kevin.tm.dao.StationMapper;
import kevin.tm.dao.model.StationBean;
import kevin.tm.dao.model.StationBeanExample;
import kevin.tm.model.Station;
import kevin.tm.service.StationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Diluka
 * 
 */
@Scope("prototype")
@Service("stationServiceImpl")
public class StationServiceImpl implements StationService {

    @Autowired
    private StationBeanMapper stationBeanMapper;

    @Autowired
    private StationMapper stationMapper;

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
     * @see
     * kevin.tm.service.StationService#update(kevin.tm.dao.model.StationBean)
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
    public Station findById(Integer stationId) {
	return this.stationMapper.getById(stationId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.StationService#findAll()
     */
    @Override
    public List<Station> findAll() {
	return this.stationMapper.getAll();
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.StationService#findByName(java.lang.String)
     */
    @Override
    public List<Station> findByName(String stationName) {
	return this.stationMapper.getByName(stationName);
    }

    @Override
    public int count() {
	StationBeanExample stationBeanExample = new StationBeanExample();
	stationBeanExample.clear();
	stationBeanExample.createCriteria().getAllCriteria();
	return this.stationBeanMapper.countByExample(stationBeanExample);
    }

}
