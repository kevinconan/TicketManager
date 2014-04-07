package kevin.tm.dao;

import java.util.List;

import kevin.tm.dao.model.Ticketinfo;
import kevin.tm.dao.model.TicketinfoExample;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface TicketinfoMapper {
    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table ticketinfo
     * 
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    int countByExample(TicketinfoExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table ticketinfo
     * 
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    List<Ticketinfo> selectByExample(TicketinfoExample example);

    List<Ticketinfo> selectByExample(TicketinfoExample example,
	    RowBounds rowBounds);

    @Select("select * from ticketinfo where ${searchClause}")
    List<Ticketinfo> selectByPage(RowBounds rowBounds,@Param("searchClause")String searchClause);
}