package kevin.tm.model;

public class RouteBean {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Route.RouteId
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	private Integer routeid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Route.StartStationId
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	private Integer startstationid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Route.EndStationId
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	private Integer endstationid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Route.RouteName
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	private String routename;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Route.RouteId
	 * @return  the value of Route.RouteId
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public Integer getRouteid() {
		return routeid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Route.RouteId
	 * @param routeid  the value for Route.RouteId
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public void setRouteid(Integer routeid) {
		this.routeid = routeid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Route.StartStationId
	 * @return  the value of Route.StartStationId
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public Integer getStartstationid() {
		return startstationid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Route.StartStationId
	 * @param startstationid  the value for Route.StartStationId
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public void setStartstationid(Integer startstationid) {
		this.startstationid = startstationid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Route.EndStationId
	 * @return  the value of Route.EndStationId
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public Integer getEndstationid() {
		return endstationid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Route.EndStationId
	 * @param endstationid  the value for Route.EndStationId
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public void setEndstationid(Integer endstationid) {
		this.endstationid = endstationid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Route.RouteName
	 * @return  the value of Route.RouteName
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public String getRoutename() {
		return routename;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Route.RouteName
	 * @param routename  the value for Route.RouteName
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public void setRoutename(String routename) {
		this.routename = routename == null ? null : routename.trim();
	}
}