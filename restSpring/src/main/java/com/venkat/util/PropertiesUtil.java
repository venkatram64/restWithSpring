package com.venkat.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertiesUtil extends PropertyPlaceholderConfigurer {
	
	@SuppressWarnings("unused")
	private static Log log = LogFactory.getLog(PropertiesUtil.class);
	
	public static final String BASE_WEB_SERVICE_URL = "variableserver.baseWebServiceURL"; 
	
	
    private static Map<String, String> propertiesMap; 
    
    private static final String DEFAULT = ".default";
    private static String environment = DEFAULT;
    

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {
    	 
    	
    	super.processProperties(beanFactory, props);

        propertiesMap = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            propertiesMap.put(keyStr, props.getProperty(keyStr));
        }
    } 
    
    public static String getProperty(String key) {
    	String environment = ".default";
		String value = null;
		if(key.contains("variableserver.")) {

			if(propertiesMap.size() <= 0) {
				System.out.println("Properties file map is empty.");
			}
			
			value =  propertiesMap.get(key + environment);
		}
		else {
			value = propertiesMap.get(key);
		}
		value = (value == null) ? null : value.trim();
		return value;
	}
	
	public static boolean getBooleanProperty(String key) {
		String value = getProperty(key); 
		if( value != null && (value.equals("true") || value.equals("1")) ) {
			return true;
		} 
		return false;
	} 

	public static int getIntegerProperty(String key) {
		String value = getProperty(key);
		if( value != null)
			return Integer.parseInt(getProperty(key));
		else
			return Integer.MIN_VALUE;
	}
	
	
	
	public static boolean isDefault() {
		return (environment.equalsIgnoreCase(DEFAULT));
	}
	
	
}
