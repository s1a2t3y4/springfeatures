 
package com.satya.springfeatures.springfeatures;

import java.util.Date;
import java.util.Properties;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.satya.springfeatures.annotation.Test;
import com.satya.springfeatures.client.SpringClient;
import com.satya.springfeatures.model.Request;
import com.satya.springfeatures.springfeaturesspi.SpringContextAware;
import com.satya.springfeatures.springfeaturesspi.SpringParameter;
import com.satya.springfeatures.springfeaturesspi.SpringQualifier;
import com.satya.springfeatures.util.Utils;

/**
 *
 * @author Satya Vulisetti
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Aspect
public class SpringAspect {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(SpringAspect.class);

	/** For retrieving users information **/
	@Autowired
	SpringContextAware springContextAware;
	
	/** For retrieving parameter information **/
    @Autowired(required=false)
    SpringParameter springParameter;
   
    /** For retrieving qualifier information **/
    @Autowired(required=false)
    SpringQualifier springQualifier;

	/** For as asynchronously saving information **/
	@Autowired
	SpringClient springClient;

	/**
	 * implemented this method for ing methods which are annotated with
	 *  annotation
	 * 
	 * 
	 * @return boolean which should will give result
	 */
	@Around(value = "@annotation(test)", argNames = "test")
	public Object around(ProceedingJoinPoint joinPoint, Test test) throws Throwable {
		Object result = null;

		 

		 

		try {
		    //syso(before)
			result = joinPoint.proceed();
			//syso(after)
			 
		}

		catch (Throwable ex) {
			 throw ex;
		} finally {
			try {
				 springClient.saveRequestInfo(new Request());
			} catch (Exception ex) {
				logger.info("error while saving  Information");
			}

		}
		return result;
	}

	 

}
