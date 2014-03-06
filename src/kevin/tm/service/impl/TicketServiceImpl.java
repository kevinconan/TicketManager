/**
 * 
 */
package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.TicketBeanMapper;
import kevin.tm.dao.TicketMapper;
import kevin.tm.dao.model.TicketBean;
import kevin.tm.dao.model.TicketBeanExample;
import kevin.tm.model.Ticket;
import kevin.tm.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Diluka
 * 
 */
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketBeanMapper ticketBeanMapper;

    @Autowired
    private TicketMapper ticketMapper;

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#save(kevin.tm.dao.model.TicketBean)
     */
    @Override
    public int save(TicketBean ticketBean) {
	return this.ticketBeanMapper.insert(ticketBean);
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
    public Ticket findById(Integer ticketId) {
	return this.ticketMapper.getById(ticketId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#findAll()
     */
    @Override
    public List<Ticket> findAll() {
	return this.ticketMapper.getAll();
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#findByCustomerName(java.lang.String)
     */
    @Override
    public List<Ticket> findByCustomerName(String customerName) {
	return this.ticketMapper.getByCustomerName(customerName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#findByTicketNo(java.lang.String)
     */
    @Override
    public Ticket findByTicketNo(String ticketNo) {
	return this.findByTicketNo(ticketNo);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.TicketService#findByScheduleId(java.lang.Integer)
     */
    @Override
    public List<Ticket> findByScheduleId(Integer scheduleId) {
	return this.ticketMapper.getByScheduleId(scheduleId);
    }

    @Override
    public int count() {
	TicketBeanExample ticketBeanExample = new TicketBeanExample();
	ticketBeanExample.clear();
	ticketBeanExample.createCriteria().getAllCriteria();
	return this.ticketBeanMapper.countByExample(ticketBeanExample);
    }

}
