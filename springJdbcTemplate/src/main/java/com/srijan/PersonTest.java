package com.srijan;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
	
	public static void main(String[] args){
		//create();
		display();
		delete();
		display();
	}
	private static void delete(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		PersonImpl pimpl = (PersonImpl) ctx.getBean("person");
		Person p = new Person();
		p.setFirstName("EEE");
		p.setLastName("yyyyy");
		pimpl.delete(p);
		
	}
	private static void display(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		PersonImpl pimpl = (PersonImpl) ctx.getBean("person");
		List<Person> pList = pimpl.selectAll();
		for(Person p: pList){
			System.out.println(" Id: " + p.getId() + " firstName : " + p.getFirstName() + "  second name :" + p.getLastName());
		}
	}
	private static void create(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		PersonImpl pimpl = (PersonImpl) ctx.getBean("person");
		Person p = new Person();
		p.setFirstName("EEE");
		p.setLastName("yyyyy");
		pimpl.create(p);
	}

}
