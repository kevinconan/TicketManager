package kevin.tm.dao;

import java.util.List;
import kevin.tm.model.AdminBean;
import kevin.tm.model.AdminBeanExample;
import org.apache.ibatis.annotations.Param;

public interface AdminBeanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int countByExample(AdminBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int deleteByExample(AdminBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int deleteByPrimaryKey(String loginid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int insert(AdminBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int insertSelective(AdminBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    List<AdminBean> selectByExample(AdminBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    AdminBean selectByPrimaryKey(String loginid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int updateByExampleSelective(@Param("record") AdminBean record, @Param("example") AdminBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int updateByExample(@Param("record") AdminBean record, @Param("example") AdminBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int updateByPrimaryKeySelective(AdminBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int updateByPrimaryKey(AdminBean record);
}