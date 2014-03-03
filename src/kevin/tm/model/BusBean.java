package kevin.tm.model;

public class BusBean {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Bus.VehicleNo
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	private String vehicleno;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Bus.DriverName
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	private String drivername;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Bus.SeatCount
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	private Integer seatcount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Bus.BusState
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	private Integer busstate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Bus.BusStationId
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	private Integer busstationid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column Bus.BusRouteId
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	private Integer busrouteid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Bus.VehicleNo
	 * @return  the value of Bus.VehicleNo
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public String getVehicleno() {
		return vehicleno;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Bus.VehicleNo
	 * @param vehicleno  the value for Bus.VehicleNo
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno == null ? null : vehicleno.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Bus.DriverName
	 * @return  the value of Bus.DriverName
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public String getDrivername() {
		return drivername;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Bus.DriverName
	 * @param drivername  the value for Bus.DriverName
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public void setDrivername(String drivername) {
		this.drivername = drivername == null ? null : drivername.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Bus.SeatCount
	 * @return  the value of Bus.SeatCount
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public Integer getSeatcount() {
		return seatcount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Bus.SeatCount
	 * @param seatcount  the value for Bus.SeatCount
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public void setSeatcount(Integer seatcount) {
		this.seatcount = seatcount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Bus.BusState
	 * @return  the value of Bus.BusState
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public Integer getBusstate() {
		return busstate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Bus.BusState
	 * @param busstate  the value for Bus.BusState
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public void setBusstate(Integer busstate) {
		this.busstate = busstate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Bus.BusStationId
	 * @return  the value of Bus.BusStationId
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public Integer getBusstationid() {
		return busstationid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Bus.BusStationId
	 * @param busstationid  the value for Bus.BusStationId
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public void setBusstationid(Integer busstationid) {
		this.busstationid = busstationid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column Bus.BusRouteId
	 * @return  the value of Bus.BusRouteId
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public Integer getBusrouteid() {
		return busrouteid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column Bus.BusRouteId
	 * @param busrouteid  the value for Bus.BusRouteId
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public void setBusrouteid(Integer busrouteid) {
		this.busrouteid = busrouteid;
	}
}