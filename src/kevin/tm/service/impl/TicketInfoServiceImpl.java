package kevin.tm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kevin.tm.dao.TicketinfoMapper;
import kevin.tm.dao.model.RouteBean;
import kevin.tm.dao.model.RouteScheduleBean;
import kevin.tm.dao.model.Ticketinfo;
import kevin.tm.dao.model.TicketinfoExample;
import kevin.tm.service.RouteScheduleService;
import kevin.tm.service.RouteService;
import kevin.tm.service.StationService;
import kevin.tm.service.TicketInfoService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("prototype")
@Service("ticketInfoServiceImpl")
public class TicketInfoServiceImpl implements TicketInfoService {

    @Autowired
    private TicketinfoMapper mapper;
    @Autowired
    private RouteService routeService;
    @Autowired
    private StationService stationService;
    @Autowired
    private RouteScheduleService routeScheduleService;

    @Override
    public int totalCount() {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        example.createCriteria().getAllCriteria();
        return this.mapper.countByExample(example);
    }

    @Override
    public List<Ticketinfo> findByPage(int start, int limit) {
        return this.mapper.selectByPage(new RowBounds(start, limit));
    }

    @Override
    public List<Ticketinfo> findByScheduleid(Integer scheduleid, int start,
            int limit) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        example.createCriteria().andTicketscheduleidEqualTo(scheduleid);
        return this.mapper
                .selectByExample(example, new RowBounds(start, limit));
    }

    @Override
    public List<Ticketinfo> findByCustomer(String name, int start, int limit) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        example.createCriteria().andCustomernameEqualTo(name);
        return this.mapper
                .selectByExample(example, new RowBounds(start, limit));
    }

    @Override
    public List<Ticketinfo> findByStarttime(Date date, boolean isPast,
            int start, int limit) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        if (isPast) {
            example.createCriteria().andStarttimeLessThanOrEqualTo(date);
        } else {
            example.createCriteria().andStarttimeGreaterThanOrEqualTo(date);
        }
        return this.mapper
                .selectByExample(example, new RowBounds(start, limit));
    }

    @Override
    public List<Ticketinfo> findByEndtime(Date date, boolean isPast, int start,
            int limit) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        if (isPast) {
            example.createCriteria().andEndtimeLessThanOrEqualTo(date);
        } else {
            example.createCriteria().andEndtimeGreaterThanOrEqualTo(date);
        }
        return this.mapper
                .selectByExample(example, new RowBounds(start, limit));
    }

    @Override
    public List<Ticketinfo> findByStarttime(Date begin, Date untill, int start,
            int limit) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        example.createCriteria().andStarttimeBetween(begin, untill);
        return this.mapper
                .selectByExample(example, new RowBounds(start, limit));
    }

    @Override
    public List<Ticketinfo> findByEndtime(Date begin, Date untill, int start,
            int limit) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        example.createCriteria().andEndtimeBetween(begin, untill);
        return this.mapper
                .selectByExample(example, new RowBounds(start, limit));
    }

    @Override
    public List<Ticketinfo> findByRoutename(String routename, Date begin,
            Date untill, int start, int limit) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        example.createCriteria().andRoutenameLike(routename)
                .andStarttimeBetween(begin, untill);
        return this.mapper
                .selectByExample(example, new RowBounds(start, limit));
    }

    @Override
    public List<Ticketinfo> findByRoutename(String routename, int start,
            int limit) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        example.createCriteria().andRoutenameLike(routename);
        return this.mapper
                .selectByExample(example, new RowBounds(start, limit));
    }

    @Override
    public int countByScheduleid(Integer scheduleid) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        example.createCriteria().andTicketscheduleidEqualTo(scheduleid);
        return this.mapper.countByExample(example);
    }

    @Override
    public List<Ticketinfo> findByRouteid(Integer routeid, Date begin,
            Date untill, int start, int limit) {
        RouteBean routeBean = this.routeService.findById(routeid);
        if (routeBean != null) {
            TicketinfoExample example = new TicketinfoExample();
            example.clear();
            example.createCriteria()
                    .andRoutenameEqualTo(routeBean.getRoutename())
                    .andStarttimeBetween(begin, untill);
            return this.mapper.selectByExample(example, new RowBounds(start,
                    limit));
        }
        return null;
    }

    @Override
    public List<Ticketinfo> findByRouteid(Integer routeid, int start, int limit) {
        RouteBean routeBean = this.routeService.findById(routeid);
        if (routeBean != null) {
            TicketinfoExample example = new TicketinfoExample();
            example.clear();
            example.createCriteria().andRoutenameEqualTo(
                    routeBean.getRoutename());
            return this.mapper.selectByExample(example, new RowBounds(start,
                    limit));
        }
        return null;
    }

    @Override
    public int countByCustomer(String name) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        example.createCriteria().andCustomernameEqualTo(name);
        return mapper.countByExample(example);
    }

    @Override
    public int countByStarttime(Date date, boolean isPast) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        if (isPast) {
            example.createCriteria().andStarttimeLessThanOrEqualTo(date);
        } else {
            example.createCriteria().andStarttimeGreaterThanOrEqualTo(date);
        }
        return mapper.countByExample(example);
    }

    @Override
    public int countByStarttime(Date begin, Date untill) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        example.createCriteria().andStarttimeBetween(begin, untill);
        return mapper.countByExample(example);
    }

    @Override
    public int countByEndtime(Date date, boolean isPast) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        if (isPast) {
            example.createCriteria().andEndtimeLessThanOrEqualTo(date);
        } else {
            example.createCriteria().andEndtimeGreaterThanOrEqualTo(date);
        }
        return mapper.countByExample(example);
    }

    @Override
    public int countByEndtime(Date begin, Date untill) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        example.createCriteria().andEndtimeBetween(begin, untill);
        return mapper.countByExample(example);
    }

    @Override
    public int countByRoutename(String routename, Date begin, Date untill) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        example.createCriteria().andRoutenameLike(routename)
                .andStarttimeBetween(begin, untill);
        return mapper.countByExample(example);
    }

    @Override
    public int countByRoutename(String routename) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        example.createCriteria().andRoutenameLike(routename);
        return mapper.countByExample(example);
    }

    @Override
    public int countByRouteid(Integer routeid, Date begin, Date untill) {
        RouteBean routeBean = this.routeService.findById(routeid);
        if (routeBean != null) {
            TicketinfoExample example = new TicketinfoExample();
            example.clear();
            example.createCriteria()
                    .andRoutenameEqualTo(routeBean.getRoutename())
                    .andStarttimeBetween(begin, untill);
            return mapper.countByExample(example);
        }
        return 0;
    }

    @Override
    public int countByRouteid(Integer routeid) {
        RouteBean routeBean = this.routeService.findById(routeid);
        if (routeBean != null) {
            TicketinfoExample example = new TicketinfoExample();
            example.clear();
            example.createCriteria().andRoutenameEqualTo(
                    routeBean.getRoutename());
            return mapper.countByExample(example);
        }
        return 0;
    }

    @Override
    public List<Ticketinfo> findByStation(String startStation, String endStation, int start, int limit) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        example.createCriteria().andStartstationnameLike(startStation).andEndstationnameLike(endStation);
        return mapper.selectByExample(example, new RowBounds(start, limit));
    }

    @Override
    public int countByStation(String startStation, String endStation) {
        TicketinfoExample example = new TicketinfoExample();
        example.clear();
        example.createCriteria().andStartstationnameLike(startStation).andEndstationnameLike(endStation);
        return mapper.countByExample(example);
    }

    @Override
    public List<Ticketinfo> findByStation(Integer startStation, Integer endStation, int start, int limit) {
        List<RouteBean> routeBeans;
        if (startStation == null && endStation == null) {
            routeBeans = null;
        } else if (endStation == null) {
            routeBeans = routeService.findByStartStationid(startStation);
        } else if (startStation == null) {
            routeBeans = routeService.findByEndStationid(endStation);
        } else {
            routeBeans = routeService.findByStartEndStationid(startStation, endStation);
        }
        if (routeBeans == null) {
            return null;
        } else {
            List<RouteScheduleBean> routeScheduleBeans = routeScheduleService.findByRouteBeans(routeBeans);
            List<Integer> scheduleIds = new ArrayList<>();
            for (RouteScheduleBean bean : routeScheduleBeans) {
                scheduleIds.add(bean.getScheduleid());
            }
            TicketinfoExample example = new TicketinfoExample();
            example.clear();
            example.createCriteria().andTicketscheduleidIn(scheduleIds);
            return mapper.selectByExample(example, new RowBounds(start, limit));
        }
    }

    @Override
    public int countByStation(Integer startStation, Integer endStation) {
        List<RouteBean> routeBeans;
        if (startStation == null && endStation == null) {
            routeBeans = null;
        } else if (endStation == null) {
            routeBeans = routeService.findByStartStationid(startStation);
        } else if (startStation == null) {
            routeBeans = routeService.findByEndStationid(endStation);
        } else {
            routeBeans = routeService.findByStartEndStationid(startStation, endStation);
        }
        if (routeBeans == null) {
            return 0;
        } else {
            List<RouteScheduleBean> routeScheduleBeans = routeScheduleService.findByRouteBeans(routeBeans);
            List<Integer> scheduleIds = new ArrayList<>();
            for (RouteScheduleBean bean : routeScheduleBeans) {
                scheduleIds.add(bean.getScheduleid());
            }
            TicketinfoExample example = new TicketinfoExample();
            example.clear();
            example.createCriteria().andTicketscheduleidIn(scheduleIds);
            return mapper.countByExample(example);
        }
    }

}
