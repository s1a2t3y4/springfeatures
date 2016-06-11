 
package com.satya.springfeatures;

import javax.ws.rs.ApplicationPath;

import org.springframework.context.annotation.Configuration;
 import org.glassfish.jersey.server.ResourceConfig;

/**
 * The Class JerseyConfig.
 *
 * @author :Satya Vulisetti
 * @version :1.0.0
 * @since :1.0.0
 */
@Configuration
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

	/**
	 * Instantiates a new jersey config.
	 */
	public JerseyConfig() {
		packages("com.sca.springfeatures.service");
	}
}
