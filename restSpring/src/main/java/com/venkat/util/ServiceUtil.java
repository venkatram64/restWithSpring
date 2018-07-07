package com.venkat.util;

import java.net.MalformedURLException;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

public class ServiceUtil {

	@SuppressWarnings({ "rawtypes" })
	public static Object findService(Class clazz, String serviceNameStr)
			throws MalformedURLException {
		String baseURL = PropertiesUtil.getProperty(PropertiesUtil.BASE_WEB_SERVICE_URL);
		//String baseURL = "http://localhost:8082/restSpring";
		String ENDPOINT_URL = baseURL + "/" + serviceNameStr;
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
    	factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(clazz);
		factory.setAddress(ENDPOINT_URL);
		Object serviceInterface = factory.create();
		try {
			Client client = ClientProxy.getClient(serviceInterface);
			if (client != null) {
				HTTPConduit conduit = (HTTPConduit) client.getConduit();
				HTTPClientPolicy policy = new HTTPClientPolicy();
				policy.setConnectionTimeout(10000);
				policy.setReceiveTimeout(5000000);
				conduit.setClient(policy);
			}
		}
		catch (Exception e) {
			System.out
					.println("Error while setting request/receive timeout in web service connection ::");
		}
		return serviceInterface;
	}

}
