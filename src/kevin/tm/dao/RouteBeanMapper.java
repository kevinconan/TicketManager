package kevin.tm.dao;

import java.util.List;
import kevin.tm.model.RouteBean;
import kevin.tm.model.RouteBeanExample;
import org.apache.ibatis.annotations.Param;

public interface RouteBeanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Route
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int countByExample(RouteBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Route
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int deleteByExample(RouteBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Route
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int deleteByPrimaryKey(Integer routeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Route
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int insert(RouteBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Route
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int insertSelective(RouteBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Route
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    List<RouteBean> selectByExample(RouteBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Route
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    RouteBean selectByPrimaryKey(Integer routeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Route
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int updateByExampleSelective(@Param("record") RouteBean record, @Param("example") RouteBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Route
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int updateByExample(@Param("record") RouteBean record, @Param("example") RouteBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Route
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int updateByPrimaryKeySelective(RouteBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Route
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    int updateByPrimaryKey(RouteBean record);
}