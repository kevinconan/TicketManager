/**
 * 
 */
package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.RouteBeanMapper;
import kevin.tm.dao.RouteMapper;
import kevin.tm.dao.model.RouteBean;
import kevin.tm.dao.model.RouteBeanExample;
import kevin.tm.model.Route;
import kevin.tm.service.RouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Diluka
 * 
 */
@Scope("prototype")
@Service("routeServiceImpl")
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteBeanMapper routeBeanMapper;
    @Autowired
    private RouteMapper routeMapper;

    public RouteBeanMapper getRouteBeanMapper() {
	return this.routeBeanMapper;
    }

    public void setRouteBeanMapper(RouteBeanMapper routeBeanMapper) {
	this.routeBeanMapper = routeBeanMapper;
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.RouteService#save(kevin.tm.dao.model.RouteBean)
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
     * @see kevin.tm.service.RouteService#update(kevin.tm.dao.model.RouteBean)
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
    public Route findById(Integer routeId) {
	return this.routeMapper.getById(routeId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.RouteService#findAll()
     */
    @Override
    public List<Route> findAll() {
	return this.routeMapper.getAll();
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.RouteService#findByName(java.lang.String)
     */
    @Override
    public List<Route> findByName(String routeName) {
	return this.routeMapper.getByName(routeName);
    }

    @Override
    public int count() {
	RouteBeanExample routeBeanExample = new RouteBeanExample();
	routeBeanExample.clear();
	routeBeanExample.createCriteria().getAllCriteria();
	return this.routeBeanMapper.countByExample(routeBeanExample);
    }

}
