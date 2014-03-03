/**
 * 
 */
package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.TicketMapper;
import kevin.tm.model.TicketBean;
import kevin.tm.model.TicketBeanExample;
import kevin.tm.service.TicketService;

/**
 * @author Diluka
 * 
 */
public class TicketServiceImpl implements TicketService {

    private TicketMapper ticketMapper;

    public TicketMapper getTicketMapper() {
	return this.ticketMapper;
    }

    public void setTicketMapper(TicketMapper ticketMapper) {
	this.ticketMapper = ticketMapper;
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#save(kevin.tm.model.TicketBean)
     */
    @Override
    public int save(TicketBean ticketBean) {
	return this.ticketMapper.insert(ticketBean);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#deleteById(java.lang.Integer)
     */
    @Override
    public int deleteById(Integer ticketId) {
	return this.ticketMapper.deleteByPrimaryKey(ticketId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#update(kevin.tm.model.TicketBean)
     */
    @Override
    public int update(TicketBean ticketBean) {
	return this.ticketMapper.updateByPrimaryKey(ticketBean);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#findById(java.lang.Integer)
     */
    @Override
    public TicketBean findById(Integer ticketId) {
	return this.ticketMapper.selectByPrimaryKey(ticketId);
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
	return this.ticketMapper.selectByExample(ticketBeanExample);
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
	return this.ticketMapper.selectByExample(ticketBeanExample);
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
	List<TicketBean> list = this.ticketMapper
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
	return this.ticketMapper.selectByExample(ticketBeanExample);
    }

}
