package integration.com.satya.spring.utils;

import org.springframework.stereotype.Component;

import com.satya.springfeatures.springfeaturesspi.SpringOutput;
import com.satya.springfeatures.springfeaturesspi.SpringParameter;
import com.satya.springfeatures.springfeaturesspi.SpringQualifier;
 
@Component
public class ParameterWithInterfaces implements SpringOutput, SpringQualifier, SpringParameter {

    private String qualifierName="football";
    private String parameterName="goal keeper";
    private String parameterValue="vicky";
    
    public void setQualifierName(String qualifierName) {
        this.qualifierName = qualifierName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    
    
	@Override
	public String parameterName() {
		return parameterName;
	}

	@Override
	public String parameterValue() {
		return parameterValue;
	}

	@Override
	public String qualifierName() {
		return qualifierName;
	}

	@Override
	public boolean isSuccess() {
		return false;
	}

}
