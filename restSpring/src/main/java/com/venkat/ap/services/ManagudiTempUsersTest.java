package com.venkat.ap.services;

import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.srijan.ap.model.APTempManagudiUser;
import com.venkat.ap.core.IAPTempManagudiUsersService;

public class ManagudiTempUsersTest {
	public static void main(String[] args){
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

    	factory.getInInterceptors().add(new LoggingInInterceptor());
    	factory.getOutInterceptors().add(new LoggingOutInterceptor());
    	//factory.getOutInterceptors().add(new WebServiceOutboundMessageInterceptor());
    	factory.setServiceClass(IAPTempManagudiUsersService.class);
    	factory.setAddress("http://localhost:8082/restSpring/cxfTempManagudiUsers");
    	IAPTempManagudiUsersService client = (IAPTempManagudiUsersService) factory.create();

    	 APTempManagudiUser user = new APTempManagudiUser();
		 user.setCategory("BAJANAMANDALI");
		 user.setDistName("WARANGAL");
		 user.setMandalName("MOGULLAPALLE");
		 user.setVillageName("GUDIPHAD");
		 user.setTempleName("SRI RAM TEMPLE");
		 user.setName("VENKATRAM");
		 user.setEmail("v@v.com");
		 user.setPhone("1234");
		 user.setApproved(0);
    	List<APTempManagudiUser> pList = client.create(user);
		for(APTempManagudiUser p: pList){
			System.out.println(" Id: " + p.getId() + " firstName : " + p.getName() + " date " + p.getTempleName());
		}
    	System.exit(0);
	}
}
