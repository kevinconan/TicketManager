package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.TicketinfoMapper;
import kevin.tm.dao.model.Ticketinfo;
import kevin.tm.dao.model.TicketinfoExample;
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

}
