package kevin.tm.model;

public class StationBean {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Station.StationId
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    private Integer stationid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Station.StationName
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    private String stationname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Station.LocationX
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    private Double locationx;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Station.LocationY
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    private Double locationy;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Station.StationId
     *
     * @return the value of Station.StationId
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public Integer getStationid() {
        return stationid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Station.StationId
     *
     * @param stationid the value for Station.StationId
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public void setStationid(Integer stationid) {
        this.stationid = stationid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Station.StationName
     *
     * @return the value of Station.StationName
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public String getStationname() {
        return stationname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Station.StationName
     *
     * @param stationname the value for Station.StationName
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public void setStationname(String stationname) {
        this.stationname = stationname == null ? null : stationname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Station.LocationX
     *
     * @return the value of Station.LocationX
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public Double getLocationx() {
        return locationx;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Station.LocationX
     *
     * @param locationx the value for Station.LocationX
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public void setLocationx(Double locationx) {
        this.locationx = locationx;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Station.LocationY
     *
     * @return the value of Station.LocationY
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public Double getLocationy() {
        return locationy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Station.LocationY
     *
     * @param locationy the value for Station.LocationY
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public void setLocationy(Double locationy) {
        this.locationy = locationy;
    }
}