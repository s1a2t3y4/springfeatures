 
package com.satya.springfeatures.springfeatures;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

 
public class SpringApectCondition implements Condition {

	/**
	 * this method checks to enable and disable aspects.
	 * 
	 * 
	 * @return boolean
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		boolean result = false;
		if (context.getEnvironment().getProperty("service.endpoint.enable") != null) {
			result = (context.getEnvironment().getProperty("service.endpoint.enable").toString().trim().equals("true"));
		}
		return result;
	}

}
