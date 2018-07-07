package com.srijan.ap.core;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srijan.ap.dao.APTempManagudiUsersDao;
import com.srijan.ap.dao.APVillageDao;
import com.srijan.ap.dao.ManagudiUsersSearchDao;
import com.srijan.ap.model.APTempManagudiUser;
import com.srijan.ap.model.ManagudiUsers;

public class ManagudiUsersTest {
	public static void main(String[] args){
		//create();
		//tempDisplay();
		display1();
	}
	
	private static void display(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		ManagudiUsersSearchDao users = (ManagudiUsersSearchDao) ctx.getBean("managudiUsers");
		List<ManagudiUsers> pList = users.searchManagudiUser("BAJANAMANDALI", "KHAMMAM",
				"YERRUPALEM", "BANIGANDLAPADU");
		for(ManagudiUsers p: pList){
			System.out.println(" Id: " + p.getId() + " firstName : " + p.getName() + " date " + p.getCreatedDate());
		}
	}
	
	private static void display1(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		APVillageDao users = (APVillageDao) ctx.getBean("apVillage");
		List<ManagudiUsers> pList = users.searchManagudiUserById("BAJANAMANDALI", "22",
				"46", "12");
		for(ManagudiUsers p: pList){
			System.out.println(" Id: " + p.getId() + " firstName : " + p.getName() + " date " + p.getCreatedDate());
		}
	}
	
	private static void tempDisplay(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		APTempManagudiUsersDao users = (APTempManagudiUsersDao) ctx.getBean("tempManagudiUsers");
		APTempManagudiUser user = new APTempManagudiUser();
		 user.setCategory("BAJANAMANDALI");
		 user.setDistName("WARANGAL");
		 user.setMandalName("MOGULLAPALLE");
		 user.setVillageName("GUDIPHAD");
		 user.setTempleName("SRI RAM TEMPLE");
		 user.setName("VENKATRAM");
		 user.setEmail("v@v.com");
		 user.setPhone("1234");
		List<APTempManagudiUser> pList = users.create(user);
		for(APTempManagudiUser p: pList){
			System.out.println(" Id: " + p.getId() + " firstName : " + p.getName() + " date " + p.getTempleName());
		}
	}
}
