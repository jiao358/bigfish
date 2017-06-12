package ext.util.helper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class CmbProperty extends PropertyPlaceholderConfigurer {
	private final static Logger logger = LogManager.getLogger(CmbProperty.class.getName());
	private static final String regex="^\\$\\{.+\\}$";
	
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		String returnPropertyValue="";
		if(propertyValue.matches(regex)){
			try {
				logger.info("LOAD property -->"+propertyValue.substring(2,propertyValue.length()-1));
				returnPropertyValue = SecurityAES.decrypt(propertyValue.substring(2,propertyValue.length()-1));
			} catch (Exception e) {
				logger.error("initial properties "+propertyName+" error",e);
			}
		}else{
			returnPropertyValue=propertyValue;
		}
		
		return returnPropertyValue;
	}
	
}
