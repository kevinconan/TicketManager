/**
 * 
 */
package kevin.tm.service;

import java.util.List;

import kevin.tm.dao.model.TicketBean;
import kevin.tm.model.Ticket;

/**
 * 车票Service接口
 * 
 * @author Diluka
 * 
 */
public interface TicketService {
    /**
     * 保存
     * 
     * @param ticketBean
     * @return
     */
    public int save(TicketBean ticketBean);

    /**
     * ID删除
     * 
     * @param ticketId
     * @return
     */
    public int deleteById(Integer ticketId);

    /**
     * 修改
     * 
     * @param ticketBean
     * @return
     */
    public int update(TicketBean ticketBean);

    /**
     * ID查找
     * 
     * @param ticketId
     * @return
     */
    public Ticket findById(Integer ticketId);

    /**
     * 查找全部
     * 
     * @return
     */
    public List<Ticket> findAll();

    /**
     * 客户名查找
     * 
     * @param customerName
     * @return
     */
    public List<Ticket> findByCustomerName(String customerName);

    /**
     * 车票编号查找
     * 
     * @param ticketNo
     * @return
     */
    public Ticket findByTicketNo(String ticketNo);

    /**
     * 日程ID查找
     * 
     * @param scheduleId
     * @return
     */
    public List<Ticket> findByScheduleId(Integer scheduleId);

    public int count();
}
