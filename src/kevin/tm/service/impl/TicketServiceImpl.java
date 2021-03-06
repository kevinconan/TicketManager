/**
 * 
 */
package kevin.tm.service.impl;

import java.util.Date;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.List;

import kevin.tm.dao.TicketBeanMapper;
import kevin.tm.dao.model.TicketBean;
import kevin.tm.dao.model.TicketBeanExample;
import kevin.tm.service.TicketService;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Diluka
 * 
 */
@Scope("prototype")
@Service("ticketServiceImpl")
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketBeanMapper ticketBeanMapper;

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#save(kevin.tm.dao.model.TicketBean)
     */
    @Override
    public int save(TicketBean ticketBean) {
    	int scheduleId = ticketBean.getTicketscheduleid();
    	if(ticketBeanMapper.countRemainSeatBySchid(scheduleId)>0){
	    	ticketBean.setTicketno(new SimpleDateFormat(scheduleId+"yyyyMMddHHmmssSSS").format(new Date()));
	    	List<String> selledSeats = ticketBeanMapper.getSeatList(scheduleId);
	    	int totalSeats = ticketBeanMapper.getTotalSeats(scheduleId);
	    	for(Integer i=1;i<=totalSeats;i++){
	    		if(!selledSeats.contains(i.toString())){
	    			ticketBean.setSeatno(i.toString());
	    			break;
	    		}
	    	}
	    	return this.ticketBeanMapper.insertSelective(ticketBean);
    	
    	}
    	
    	
	return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#deleteById(java.lang.Integer)
     */
    @Override
    public int deleteById(Integer ticketId) {
	return this.ticketBeanMapper.deleteByPrimaryKey(ticketId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#update(kevin.tm.dao.model.TicketBean)
     */
    @Override
    public int update(TicketBean ticketBean) {
	return this.ticketBeanMapper.updateByPrimaryKey(ticketBean);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#findById(java.lang.Integer)
     */
    @Override
    public TicketBean findById(Integer ticketId) {
	return this.ticketBeanMapper.selectByPrimaryKey(ticketId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#findAll()
     */
    @Override
    public List<TicketBean> findAll() {
	TicketBeanExample ticketBeanExample = new TicketBeanExample();
	ticketBeanExample.clear();
	ticketBeanExample.createCriteria().getAllCriteria();
	return this.ticketBeanMapper.selectByExample(ticketBeanExample);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#findByCustomerName(java.lang.String)
     */
    @Override
    public List<TicketBean> findByCustomerName(String customerName) {
	TicketBeanExample ticketBeanExample = new TicketBeanExample();
	ticketBeanExample.clear();
	ticketBeanExample.createCriteria().andCustomernameEqualTo(customerName);
	return this.ticketBeanMapper.selectByExample(ticketBeanExample);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#findByTicketNo(java.lang.String)
     */
    @Override
    public TicketBean findByTicketNo(String ticketNo) {
	TicketBeanExample ticketBeanExample = new TicketBeanExample();
	ticketBeanExample.clear();
	ticketBeanExample.createCriteria().andTicketnoEqualTo(ticketNo);
	List<TicketBean> list = this.ticketBeanMapper
		.selectByExample(ticketBeanExample);
	return list.size() > 0 ? list.get(0) : null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#findByScheduleId(java.lang.Integer)
     */
    @Override
    public List<TicketBean> findByScheduleId(Integer scheduleId) {
	TicketBeanExample ticketBeanExample = new TicketBeanExample();
	ticketBeanExample.clear();
	ticketBeanExample.createCriteria().andTicketscheduleidEqualTo(
		scheduleId);
	return this.ticketBeanMapper.selectByExample(ticketBeanExample);
    }

    @Override
    public int totalCount() {
	TicketBeanExample ticketBeanExample = new TicketBeanExample();
	ticketBeanExample.clear();
	ticketBeanExample.createCriteria().getAllCriteria();
	return this.ticketBeanMapper.countByExample(ticketBeanExample);
    }

    @Override
    public List<TicketBean> findByPage(int start, int limit) {
	return this.ticketBeanMapper.selectByPage(new RowBounds(start, limit));
    }

    @Override
    public int delete(TicketBean bean) {
	return this.ticketBeanMapper.deleteByPrimaryKey(bean.getTicketid());
    }

    @Override
    public int countByScheduleid(Integer scheduleid) {
	TicketBeanExample example = new TicketBeanExample();
	example.clear();
	example.createCriteria().andTicketscheduleidEqualTo(scheduleid);
	return this.ticketBeanMapper.countByExample(example);
    }

	@Override
	public int countRemainSeatBySchid(Integer scheduleid) {
		return this.ticketBeanMapper.countRemainSeatBySchid(scheduleid);
	}

	@Override
	public int updateCheck(Integer ticketid) {
            TicketBean tb = new TicketBean();
            tb.setTicketid(ticketid);
            tb.setChecked(true);
            TicketBeanExample example = new TicketBeanExample();
            example.clear();
            example.createCriteria().andTicketidEqualTo(ticketid);
	//	return this.ticketBeanMapper.updateByExample(tb, example);
            return this.ticketBeanMapper.updateCheck(ticketid);
	}
    
	

}
