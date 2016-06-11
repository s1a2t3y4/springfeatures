 
package integration.com.satya.spring.utils;

import org.springframework.stereotype.Component;

import com.satya.springfeatures.annotation.Test;
import com.satya.springfeatures.exceptions.ServiceException;

 
@Component
public class TestBean {

	@Test(output = true)
	public boolean login(boolean result) throws ServiceException {
		if (result == true) {
			return true;
		} else {
			return false;
		}
	}

	@Test(output = false)
	public int getReport(ParameterWithInterfaces p1, int p2, String p3) {
		return p2;
	}

	@Test(output = true)
	public MethodOutputImpl login() {
		return new MethodOutputImpl();
	}
	
	@Test(output = false)
    public void testTimes() throws InterruptedException {
          Thread.sleep(100);
    }

}
