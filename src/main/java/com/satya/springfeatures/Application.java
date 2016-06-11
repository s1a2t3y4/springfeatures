/*
 * Application.java
 * 
 * Copyright 2015 SCA Technologies corp. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.satya.springfeatures;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.velocity.VelocityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * Spring application entry point.
 *
 * @author Satya Vulisetti
 * @version 1.0.0
 * @since 1.0.0
 */

@SpringBootApplication(exclude={VelocityAutoConfiguration.class,DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.satya"}, excludeFilters=@ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "com.satya.springfeatures.springfeatures.*"))
public class Application extends SpringBootServletInitializer {  

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}