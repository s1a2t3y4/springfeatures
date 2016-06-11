 
package integration.com.satya.springfeatures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import integration.com.satya.IntegrationTestBase;
import integration.com.satya.TestConfig;
import integration.com.satya.spring.utils.TestBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.satya.springfeatures.Application;
import com.satya.springfeatures.client.SpringClient;

 

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, TestConfig.class})
@WebAppConfiguration
@IntegrationTest
@TestPropertySource(locations = "classpath:disabled-test.properties")
public class AspectDisableIntegrationTest extends IntegrationTestBase {
    @Autowired
    TestBean testBean;

    @Autowired
    SpringClient auditClient;

    /** checks there is not audit information added to database **/
    @Test
    public void testAspectAnnotation() throws Exception {
        

    }
}
