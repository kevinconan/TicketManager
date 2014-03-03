/**
 * 
 */
package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.RouteScheduleMapper;
import kevin.tm.model.RouteScheduleBean;
import kevin.tm.model.RouteScheduleBeanExample;
import kevin.tm.service.RouteScheduleService;

/**
 * @author Diluka
 * 
 */
public class RouteScheduleServiceImpl implements RouteScheduleService {

    private RouteScheduleMapper routeScheduleMapper;

    public RouteScheduleMapper getRouteScheduleMapper() {
	return this.routeScheduleMapper;
    }

    public void setRouteScheduleMapper(RouteScheduleMapper routeScheduleMapper) {
	this.routeScheduleMapper = routeScheduleMapper;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * kevin.tm.service.RouteScheduleService#save(kevin.tm.model.RouteScheduleBean
     * )
     */
    @Override
    public int save(RouteScheduleBean routeScheduleBean) {
	return this.routeScheduleMapper.insert(routeScheduleBean);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.RouteScheduleService#deleteById(java.lang.Integer)
     */
    @Override
    public int deleteById(Integer scheduleId) {
	return this.routeScheduleMapper.deleteByPrimaryKey(scheduleId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * kevin.tm.service.RouteScheduleService#update(kevin.tm.model.RouteScheduleBean
     * )
     */
    @Override
    public int update(RouteScheduleBean routeScheduleBean) {
	return this.routeScheduleMapper.updateByPrimaryKey(routeScheduleBean);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.RouteScheduleService#findById(java.lang.Integer)
     */
    @Override
    public RouteScheduleBean findById(Integer scheduleId) {
	return this.routeScheduleMapper.selectByPrimaryKey(scheduleId);
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
	return this.routeScheduleMapper
		.selectByExample(routeScheduleBeanExample);
    }

}
