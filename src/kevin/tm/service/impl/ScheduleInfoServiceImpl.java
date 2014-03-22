package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.ScheduleinfoMapper;
import kevin.tm.dao.model.Scheduleinfo;
import kevin.tm.dao.model.ScheduleinfoExample;
import kevin.tm.service.ScheduleInfoService;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("prototype")
@Service("scheduleInfoServiceImpl")
public class ScheduleInfoServiceImpl implements ScheduleInfoService {
    @Autowired
    private ScheduleinfoMapper mapper;

    @Override
    public int totalCount() {
	ScheduleinfoExample example = new ScheduleinfoExample();
	example.clear();
	example.createCriteria().getAllCriteria();
	return this.mapper.countByExample(example);
    }

    @Override
    public List<Scheduleinfo> findByPage(int start, int limit) {
	return this.mapper.selectByPage(new RowBounds(start, limit));
    }

	@Override
	public Scheduleinfo findById(int scheduleid) {
		return this.mapper.selectByScheduleId(scheduleid);
	}

}
