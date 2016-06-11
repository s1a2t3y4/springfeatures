package integration.com.satya.spring.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.satya.springfeatures.springfeaturesspi.SpringContextAware;

@Component
@Scope(value= "request", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SpringContextAwareTestImpl implements SpringContextAware {

	@Override
	public String getUserName() {
		return "test";
	}

	 
}
