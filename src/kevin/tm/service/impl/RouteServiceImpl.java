/**
 * 
 */
package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.RouteBeanMapper;
import kevin.tm.model.RouteBean;
import kevin.tm.model.RouteBeanExample;
import kevin.tm.service.RouteService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Diluka
 * 
 */
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteBeanMapper routeBeanMapper;

    public RouteBeanMapper getRouteBeanMapper() {
	return this.routeBeanMapper;
    }

    public void setRouteBeanMapper(RouteBeanMapper routeBeanMapper) {
	this.routeBeanMapper = routeBeanMapper;
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.RouteService#save(kevin.tm.model.RouteBean)
     */
    @Override
    public int save(RouteBean routeBean) {
	return this.routeBeanMapper.insert(routeBean);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.RouteService#deleteById(java.lang.Integer)
     */
    @Override
    public int deleteById(Integer routeId) {
	return this.routeBeanMapper.deleteByPrimaryKey(routeId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.RouteService#update(kevin.tm.model.RouteBean)
     */
    @Override
    public int update(RouteBean routeBean) {
	return this.routeBeanMapper.updateByPrimaryKey(routeBean);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.RouteService#findById(java.lang.Integer)
     */
    @Override
    public RouteBean findById(Integer routeId) {
	return this.routeBeanMapper.selectByPrimaryKey(routeId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.RouteService#findAll()
     */
    @Override
    public List<RouteBean> findAll() {
	RouteBeanExample routeBeanExample = new RouteBeanExample();
	routeBeanExample.clear();
	routeBeanExample.createCriteria().getAllCriteria();
	return this.routeBeanMapper.selectByExample(routeBeanExample);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.RouteService#findByName(java.lang.String)
     */
    @Override
    public List<RouteBean> findByName(String routeName) {
	// TODO Auto-generated method stub
	return null;
    }

}
