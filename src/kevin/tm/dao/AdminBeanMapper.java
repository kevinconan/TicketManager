package kevin.tm.dao;

import java.util.List;

import kevin.tm.dao.model.AdminBean;
import kevin.tm.dao.model.AdminBeanExample;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface AdminBeanMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin
     * 
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    int countByExample(AdminBeanExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin
     * 
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    int deleteByExample(AdminBeanExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin
     * 
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    int deleteByPrimaryKey(String loginid);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin
     * 
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    int insert(AdminBean record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin
     * 
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    int insertSelective(AdminBean record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin
     * 
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    List<AdminBean> selectByExample(AdminBeanExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin
     * 
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    AdminBean selectByPrimaryKey(String loginid);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin
     * 
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    int updateByExampleSelective(@Param("record") AdminBean record,
	    @Param("example") AdminBeanExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin
     * 
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    int updateByExample(@Param("record") AdminBean record,
	    @Param("example") AdminBeanExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin
     * 
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    int updateByPrimaryKeySelective(AdminBean record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin
     * 
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    int updateByPrimaryKey(AdminBean record);

    @Select("select * from admin")
    List<AdminBean> selectByPage(RowBounds rowBounds);
}