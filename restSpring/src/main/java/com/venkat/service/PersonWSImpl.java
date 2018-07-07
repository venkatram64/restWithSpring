package com.venkat.service;

import java.util.List;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import com.srijan.Person;
import com.srijan.PersonImpl;
import com.venkat.pojo.PersonCollection;

@WebService(endpointInterface = "com.venkat.service.IPersonWS", serviceName = "personService")
public class PersonWSImpl implements IPersonWS{

	PersonImpl personImpl;
	@Override
	public Person getPersonById(Long id) {
		Person p = new Person();
		p.setId(id);
		Person p_ = personImpl.findById(p);
		return p_;
	}
	
	@Override
	/*public List<Person> getPersons(){
		List<Person> p = personImpl.selectAll();
		return p;
	}*/
	public PersonCollection getPersons(){
		PersonCollection p = new PersonCollection(personImpl.selectAll());
		return p;
	}
	
	@Override
	public Person getPersonByIdObj(Person p){
		return personImpl.findById(p);
	}
	
	@Override
	public String createPerson(Person p){
		personImpl.create(p);
		return "ok";
	}
	@Override
	public String deletePerson(Person p){
		personImpl.deleteById(p);
		return "ok";
	}
	
	@Override
	public String updatePerson(Person p){
		personImpl.update(p);
		return "ok";
	}
	public PersonImpl getPersonImpl() {
		return personImpl;
	}
	public void setPersonImpl(PersonImpl personImpl) {
		this.personImpl = personImpl;
	}

}
