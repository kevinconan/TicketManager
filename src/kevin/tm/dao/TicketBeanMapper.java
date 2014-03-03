package kevin.tm.dao;

import java.util.List;
import kevin.tm.model.TicketBean;
import kevin.tm.model.TicketBeanExample;
import org.apache.ibatis.annotations.Param;

public interface TicketBeanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ticket
     *
     * @mbggenerated Mon Mar 03 15:59:33 CST 2014
     */
    int countByExample(TicketBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ticket
     *
     * @mbggenerated Mon Mar 03 15:59:33 CST 2014
     */
    int deleteByExample(TicketBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ticket
     *
     * @mbggenerated Mon Mar 03 15:59:33 CST 2014
     */
    int deleteByPrimaryKey(Integer ticketid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ticket
     *
     * @mbggenerated Mon Mar 03 15:59:33 CST 2014
     */
    int insert(TicketBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ticket
     *
     * @mbggenerated Mon Mar 03 15:59:33 CST 2014
     */
    int insertSelective(TicketBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ticket
     *
     * @mbggenerated Mon Mar 03 15:59:33 CST 2014
     */
    List<TicketBean> selectByExample(TicketBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ticket
     *
     * @mbggenerated Mon Mar 03 15:59:33 CST 2014
     */
    TicketBean selectByPrimaryKey(Integer ticketid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ticket
     *
     * @mbggenerated Mon Mar 03 15:59:33 CST 2014
     */
    int updateByExampleSelective(@Param("record") TicketBean record, @Param("example") TicketBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ticket
     *
     * @mbggenerated Mon Mar 03 15:59:33 CST 2014
     */
    int updateByExample(@Param("record") TicketBean record, @Param("example") TicketBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ticket
     *
     * @mbggenerated Mon Mar 03 15:59:33 CST 2014
     */
    int updateByPrimaryKeySelective(TicketBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Ticket
     *
     * @mbggenerated Mon Mar 03 15:59:33 CST 2014
     */
    int updateByPrimaryKey(TicketBean record);
}