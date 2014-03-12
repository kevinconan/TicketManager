package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.RouteinfoMapper;
import kevin.tm.dao.model.Routeinfo;
import kevin.tm.dao.model.RouteinfoExample;
import kevin.tm.service.RouteInfoService;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("prototype")
@Service("routeInfoServiceImpl")
public class RouteInfoServiceImpl implements RouteInfoService {
    @Autowired
    private RouteinfoMapper mapper;

    @Override
    public int totalCount() {
	RouteinfoExample example = new RouteinfoExample();
	example.clear();
	example.createCriteria().getAllCriteria();
	return this.mapper.countByExample(example);
    }

    @Override
    public List<Routeinfo> findByPage(int start, int limit) {
	return this.mapper.selectByPage(new RowBounds(start, limit));
    }

}
