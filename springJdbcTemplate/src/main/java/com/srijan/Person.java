package com.srijan;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person",namespace="http://service.venkat.com/")
public class Person implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	
	private String firstName;
	
	private String lastName;

	@XmlElement
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@XmlElement
	public String getFirstName() {
		return firstName;
	}

	@XmlElement
	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
