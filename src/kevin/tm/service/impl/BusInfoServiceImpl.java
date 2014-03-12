/**
 * 
 */
package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.BusinfoMapper;
import kevin.tm.dao.model.Businfo;
import kevin.tm.dao.model.BusinfoExample;
import kevin.tm.service.BusInfoService;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Diluka
 * 
 */
@Scope("prototype")
@Service("busInfoServiceImpl")
public class BusInfoServiceImpl implements BusInfoService {

    @Autowired
    private BusinfoMapper mapper;

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.BusInfoService#totalCount()
     */
    @Override
    public int totalCount() {
	BusinfoExample example = new BusinfoExample();
	example.clear();
	example.createCriteria().getAllCriteria();
	return this.mapper.countByExample(example);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.BusInfoService#findByPage(int, int)
     */
    @Override
    public List<Businfo> findByPage(int start, int limit) {
	return this.mapper.selectByPage(new RowBounds(start, limit));
    }

}
