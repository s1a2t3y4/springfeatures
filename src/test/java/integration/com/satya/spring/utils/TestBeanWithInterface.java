 
package integration.com.satya.spring.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.satya.springfeatures.annotation.Test;

 
@Component
public class TestBeanWithInterface implements TestInterface {

    @Autowired
    ParameterWithInterfaces parameterWithInterfaces;
    
	@Override
	@Test(output = false)
	public String getReport() {
		return "Test Report";
	}

	@Test(output = false)
    public void getQualifierInfo(String qualifiername) {
        parameterWithInterfaces.setQualifierName(qualifiername);
    }
    
	@Test(output = false)
    public void getParameterInfo(String parameterName,String parameterValue) {
        parameterWithInterfaces.setParameterName(parameterName);
        parameterWithInterfaces.setParameterValue(parameterValue);
    }
	
}
