 
package integration.com.satya.springfeatures;

import static org.junit.Assert.assertTrue;
import integration.com.satya.IntegrationTestBase;
import integration.com.satya.TestConfig;
import integration.com.satya.spring.utils.TestBean;
import integration.com.satya.spring.utils.TestBeanWithInterface;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.satya.springfeatures.Application;
import com.satya.springfeatures.client.SpringClient;
 
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class, TestConfig.class })
@WebAppConfiguration
@IntegrationTest
@TestPropertySource(locations="classpath:test.properties")
public class AspectIntegrationTest extends IntegrationTestBase {
    
	@Autowired
	TestBean testBean;
	
	@Autowired
    TestBeanWithInterface testBeanWithInterface;

	@Autowired
	SpringClient SpringClient;

	@Autowired
	ApplicationContext applicationContext;
 
	
	
	/** simple case for testing audit login method **/
	@Test
	public void testAspectAnnotation() throws Exception {
		 

	}
	
	


	/**
	 * test case included to confirm spring-aop using cg-lib proxy rather than
	 * jdk7 interface proxy
	 **/
	@Test
	public void testInstanceOf() {
		assertTrue(applicationContext.getBean("testBean") instanceof TestBean);
		assertTrue(applicationContext.getBean("testBeanWithInterface") instanceof TestBeanWithInterface);

	}
	
 

   

}
