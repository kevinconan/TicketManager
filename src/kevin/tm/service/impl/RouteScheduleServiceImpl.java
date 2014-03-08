/**
 * 
 */
package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.RouteScheduleBeanMapper;
import kevin.tm.dao.model.RouteScheduleBean;
import kevin.tm.dao.model.RouteScheduleBeanExample;
import kevin.tm.service.RouteScheduleService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Diluka
 * 
 */
public class RouteScheduleServiceImpl implements RouteScheduleService {

    @Autowired
    private RouteScheduleBeanMapper routeScheduleBeanMapper;

    public RouteScheduleBeanMapper getRouteScheduleBeanMapper() {
	return this.routeScheduleBeanMapper;
    }

    public void setRouteScheduleBeanMapper(
	    RouteScheduleBeanMapper routeScheduleBeanMapper) {
	this.routeScheduleBeanMapper = routeScheduleBeanMapper;
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.RouteScheduleService#save(kevin.tm.dao.model.
     * RouteScheduleBean )
     */
    @Override
    public int save(RouteScheduleBean routeScheduleBean) {
	return this.routeScheduleBeanMapper.insert(routeScheduleBean);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.RouteScheduleService#deleteById(java.lang.Integer)
     */
    @Override
    public int deleteById(Integer scheduleId) {
	return this.routeScheduleBeanMapper.deleteByPrimaryKey(scheduleId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.RouteScheduleService#update(kevin.tm.dao.model.
     * RouteScheduleBean )
     */
    @Override
    public int update(RouteScheduleBean routeScheduleBean) {
	return this.routeScheduleBeanMapper
		.updateByPrimaryKey(routeScheduleBean);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.RouteScheduleService#findById(java.lang.Integer)
     */
    @Override
    public RouteScheduleBean findById(Integer scheduleId) {
	return this.routeScheduleBeanMapper.selectByPrimaryKey(scheduleId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.RouteScheduleService#findAll()
     */
    @Override
    public List<RouteScheduleBean> findAll() {
	RouteScheduleBeanExample routeScheduleBeanExample = new RouteScheduleBeanExample();
	routeScheduleBeanExample.clear();
	routeScheduleBeanExample.createCriteria().getAllCriteria();
	return this.routeScheduleBeanMapper
		.selectByExample(routeScheduleBeanExample);
    }

    @Override
    public int totalCount() {
	RouteScheduleBeanExample routeScheduleBeanExample = new RouteScheduleBeanExample();
	routeScheduleBeanExample.clear();
	routeScheduleBeanExample.createCriteria().getAllCriteria();
	return this.routeScheduleBeanMapper
		.countByExample(routeScheduleBeanExample);
    }

    @Override
    public List<RouteScheduleBean> findByPage(int start, int limit) {
	return this.routeScheduleBeanMapper.selectByPage(start, limit);
    }

    @Override
    public int delete(RouteScheduleBean routeScheduleBean) {
	return this.routeScheduleBeanMapper
		.deleteByPrimaryKey(routeScheduleBean.getScheduleid());
    }

}
