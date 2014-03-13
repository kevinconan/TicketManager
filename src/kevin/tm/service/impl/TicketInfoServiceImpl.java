package kevin.tm.service.impl;

import java.util.Date;
import java.util.List;

import kevin.tm.dao.TicketinfoMapper;
import kevin.tm.dao.model.RouteBean;
import kevin.tm.dao.model.Ticketinfo;
import kevin.tm.dao.model.TicketinfoExample;
import kevin.tm.service.RouteService;
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

}
