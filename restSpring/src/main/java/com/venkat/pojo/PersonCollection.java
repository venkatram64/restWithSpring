package com.venkat.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.srijan.Person;

@XmlRootElement(name="personCollection",namespace="http://service.venkat.com/")
public class PersonCollection {

	 private List<Person> persons;
	    
	    public PersonCollection() {
	    }

	    public PersonCollection(List<Person> persons) {
	        this.persons = persons;
	    }

	    @XmlElement(name="person",namespace="http://service.venkat.com/")
	    @XmlElementWrapper(name="persons",namespace="http://service.venkat.com/")
	    public List<Person> getPersons() {
	        return persons;
	    }

		public void setPersons(List<Person> persons) {
			this.persons = persons;
		}
	    
}
