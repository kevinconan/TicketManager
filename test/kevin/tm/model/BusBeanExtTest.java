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
public class BusBeanExtTest {

    @Test
    public void test() {
	Method[] methods = BusBeanExt.class.getMethods();
	for (Method method : methods) {
	    System.out.println(method);
	}
    }

}
