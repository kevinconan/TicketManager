/**
 * 
 */
package kevin.tm.model;

import java.lang.reflect.Method;

import org.junit.Test;

/**
 * @author Diluka
 * 
 */
public class RouteTest {

    @Test
    public void test() {
	try {
	    // Route route = new Route();
	    Method[] methods = Route.class.getMethods();
	    for (Method method : methods) {
		System.out.println(method);
	    }
	    // System.out.println(routeMapper.getById(1).getEndStation().getStationname());
	    // RouteBean routeBean = this.routeBeanMapper.selectByPrimaryKey(1);
	    // System.out.println(routeBean);
	    // Route route = this.routeMapper.getById(1);
	    // System.out.println(route);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
