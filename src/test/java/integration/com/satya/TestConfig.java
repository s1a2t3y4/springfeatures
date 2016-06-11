 
package integration.com.satya;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.velocity.VelocityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.SimpleThreadScope;

/**
 * for loading spring components in test folder to application context with
 * springboot configuration
 *
 * @author Satya Vulisetti
 * @version 1.0.0
 * @since 1.0.0
 */

@SpringBootApplication(exclude=VelocityAutoConfiguration.class)
public class TestConfig {

	@Bean
	public CustomScopeConfigurer scopeConfigurer(){
		CustomScopeConfigurer newScope= new CustomScopeConfigurer();
		newScope.addScope("request",new SimpleThreadScope());
		
		return newScope;
		
	}
	
}
