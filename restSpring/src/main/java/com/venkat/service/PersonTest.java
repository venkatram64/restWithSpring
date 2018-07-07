package com.venkat.service;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.srijan.Person;
//http://www.benmccann.com/dev-blog/apache-cxf-tutorial-ws-security-with-spring/
//http://blog.wolfgang-werner.net/restful-http-with-jax-rs/
//http://www.jroller.com/gmazza/entry/web_service_tutorial
//http://www.dankulp.com/blog/2012/06/video-of-my-apache-cxf-presentation-from-camelone/
//http://cxf.apache.org/resources-and-articles.html
//http://icodingclub.blogspot.in/2011/07/introduction-of-spring-jms-with.html
//http://icodingclub.blogspot.in/2011/09/spring-jms-with-embeded-activemq-in.html
public class PersonTest {
	public static void main(String[] args){
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

    	factory.getInInterceptors().add(new LoggingInInterceptor());
    	factory.getOutInterceptors().add(new LoggingOutInterceptor());
    	//factory.getOutInterceptors().add(new WebServiceOutboundMessageInterceptor());
    	factory.setServiceClass(IPersonWS.class);
    	factory.setAddress("http://localhost:8082/restSpring/cxfPerson");
    	IPersonWS client = (IPersonWS) factory.create();

    	Person person = client.getPersonById(2l);
    	System.out.println("Server said: " + person.getLastName() + ", " + person.getFirstName());
    	System.exit(0);
	}
}
