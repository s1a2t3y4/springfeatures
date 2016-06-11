package com.satya.springfeatures.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  
 *
 * @author Satya Vulisetti
 * @version 1.0.0
 * @since 1.0.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {

	/**
	 * to find output implements output interface.
	 *
	 * @return boolean. CANNOT be NULL.
	 */
	boolean output();
}
