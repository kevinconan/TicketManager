/**
 * 
 */
package test;

import kevin.tm.model.Bus;

import com.google.gson.Gson;

/**
 * @author Diluka
 * 
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
	String json = "{\"busroute\":{\"endstation\":{\"locationx\":2.0,\"locationy\":3.0,\"stationid\":2,\"stationname\":\"测试\"},\"endstationid\":2,\"routeid\":2,\"routename\":\"呵呵\",\"startstation\":{\"locationx\":4.0,\"locationy\":5.0,\"stationid\":4,\"stationname\":\"国际村\"},\"startstationid\":4},\"busrouteid\":2,\"busstate\":44,\"busstation\":{\"locationx\":3.0,\"locationy\":3.0,\"stationid\":3,\"stationname\":\"陈家坪\"},\"busstationid\":3,\"drivername\":\"eer\",\"seatcount\":33,\"vehicleno\":\"5555\"}";
	// String json = "{\"a\":1,\"b\":{\"c\":12,\"d\":43}}";
	Gson gson = new Gson();
	Bus bus = gson.fromJson(json, Bus.class);
	System.out.println(bus.getBusstation().getStationname());
    }
}
