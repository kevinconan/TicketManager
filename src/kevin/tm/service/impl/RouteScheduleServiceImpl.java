/**
 *
 */
package kevin.tm.service.impl;

import java.util.ArrayList;
import java.util.List;
import kevin.tm.dao.RouteScheduleBeanMapper;
import kevin.tm.dao.model.BusBean;
import kevin.tm.dao.model.RouteBean;
import kevin.tm.dao.model.RouteScheduleBean;
import kevin.tm.dao.model.RouteScheduleBeanExample;
import kevin.tm.service.BusService;
import kevin.tm.service.RouteScheduleService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Diluka
 *
 */
@Scope("prototype")
@Service("routeScheduleServiceImpl")
public class RouteScheduleServiceImpl implements RouteScheduleService {

    @Autowired
    private RouteScheduleBeanMapper routeScheduleBeanMapper;
    @Autowired
    private BusService busService;

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
        return this.routeScheduleBeanMapper.insertSelective(routeScheduleBean);
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
        return this.routeScheduleBeanMapper.selectByPage(new RowBounds(start,
                limit));
    }

    @Override
    public int delete(RouteScheduleBean routeScheduleBean) {
        return this.routeScheduleBeanMapper
                .deleteByPrimaryKey(routeScheduleBean.getScheduleid());
    }

    @Override
    public int seatCount(Integer scheduleId) {
        RouteScheduleBean routeScheduleBean = this.findById(scheduleId);
        if (routeScheduleBean != null) {
            BusBean busBean = this.busService.findByBusId(routeScheduleBean
                    .getSchedulebusid());
            if (busBean != null) {
                return busBean.getSeatcount();
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    @Override
    public List<RouteScheduleBean> findByRouteid(Integer routeid) {
        RouteScheduleBeanExample routeScheduleBeanExample = new RouteScheduleBeanExample();
        routeScheduleBeanExample.clear();
        routeScheduleBeanExample.createCriteria().andSchedulerouteidEqualTo(routeid);
        return routeScheduleBeanMapper.selectByExample(routeScheduleBeanExample);
    }

    @Override
    public List<RouteScheduleBean> findByRouteids(List<Integer> routeids) {
        RouteScheduleBeanExample routeScheduleBeanExample = new RouteScheduleBeanExample();
        routeScheduleBeanExample.clear();
        routeScheduleBeanExample.createCriteria().andSchedulerouteidIn(routeids);
        return routeScheduleBeanMapper.selectByExample(routeScheduleBeanExample);
    }

    @Override
    public List<RouteScheduleBean> findByRouteBeans(List<RouteBean> routeBeans) {
        List<Integer> routeids = new ArrayList<>();
        for (RouteBean bean : routeBeans) {
            routeids.add(bean.getRouteid());
        }

        RouteScheduleBeanExample routeScheduleBeanExample = new RouteScheduleBeanExample();
        routeScheduleBeanExample.clear();
        routeScheduleBeanExample.createCriteria().andSchedulerouteidIn(routeids);
        return routeScheduleBeanMapper.selectByExample(routeScheduleBeanExample);
    }

}
