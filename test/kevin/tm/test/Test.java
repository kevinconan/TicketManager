package kevin.tm.test;

import kevin.tm.model.Bus;
import kevin.tm.model.Route;
import kevin.tm.model.Station;

import com.google.gson.Gson;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bus bus = new Bus();
		Station station = new Station();
		station.setStationid(1);
		station.setStationname("333");
		station.setLocationx(1.0);
		station.setLocationy(2.0);
		
		Route route = new Route();
		route.setStartstation(station);
		route.setRouteid(1);
		route.setRoutename("eee");
		bus.setBusstation(station);
		bus.setBusroute(route);
		Gson gson = new Gson();
		String busjson=gson.toJson(bus);
		System.out.println(busjson);
		Bus bus2=gson.fromJson(busjson, Bus.class);

		System.out.println(bus2.getBusroute().getRoutename());
	}

}
