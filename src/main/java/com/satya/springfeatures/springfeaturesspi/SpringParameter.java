 
package com.satya.springfeatures.springfeaturesspi;

 

public interface SpringParameter {

	/**
	 * implement this method for saving parameter name.
	 * 
	 * 
	 * @return string name of parameter.CAN NOT BE NULL
	 */
	String parameterName();

	/**
	 * implement this method for saving parameter value.
	 * 
	 * 
	 * @return string value of parameter.CAN NOT BE NULL
	 */
	String parameterValue();

}
