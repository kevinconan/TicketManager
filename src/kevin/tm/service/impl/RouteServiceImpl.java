/**
 * 
 */
package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.RouteBeanMapper;
import kevin.tm.dao.model.RouteBean;
import kevin.tm.dao.model.RouteBeanExample;
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
	return this.routeBeanMapper.insertSelective(routeBean);
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
	RouteBeanExample routeBeanExample = new RouteBeanExample();
	routeBeanExample.clear();
	routeBeanExample.createCriteria().andRoutenameLike(routeName);
	return this.routeBeanMapper.selectByExample(routeBeanExample);
    }

    @Override
    public int totalCount() {
	RouteBeanExample routeBeanExample = new RouteBeanExample();
	routeBeanExample.clear();
	routeBeanExample.createCriteria().getAllCriteria();
	return this.routeBeanMapper.countByExample(routeBeanExample);
    }

    @Override
    public int deleteById(int[] routeId) {
	// TODO Auto-generated method stub
	return 0;
    }

    // @Override
    // public List<RouteBean> findByPage(int start, int limit) {
    // return this.routeBeanMapper.selectByPage(start, limit);
    // }

    @Override
    public int delete(RouteBean routeBean) {
	return this.routeBeanMapper.deleteByPrimaryKey(routeBean.getRouteid());
    }

}
