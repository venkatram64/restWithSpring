package com.venkat.ap.services;

import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.srijan.ap.model.ManagudiUsers;
import com.venkat.ap.core.IManagudiUsersSearchService;

public class ManagudiUsersTest {
	public static void main(String[] args){
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

    	factory.getInInterceptors().add(new LoggingInInterceptor());
    	factory.getOutInterceptors().add(new LoggingOutInterceptor());
    	//factory.getOutInterceptors().add(new WebServiceOutboundMessageInterceptor());
    	factory.setServiceClass(IManagudiUsersSearchService.class);
    	factory.setAddress("http://localhost:8082/restSpring/cxfManagudiUsers");
    	IManagudiUsersSearchService client = (IManagudiUsersSearchService) factory.create();

    	List<ManagudiUsers> pList = client.searchManagudiUser("BAJANAMANDALI", "KHAMMAM",
				"YERRUPALEM", "BANIGANDLAPADU");
		for(ManagudiUsers p: pList){
			System.out.println(" Id: " + p.getId() + " firstName : " + p.getName() + " date " + p.getCreatedDate());
		}
    	System.exit(0);
	}
}
