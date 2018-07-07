package com.venkat.service;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.srijan.Person;
import com.srijan.PersonImpl;
import com.venkat.pojo.PersonCollection;
import com.venkat.util.ServiceUtil;
//http://middlewaremagic.com/jboss/?tag=webservice
//https://docs.jboss.org/jbossas/7/plugins/maven/latest/
//https://github.com/jbossas/jboss-as-maven-plugin
@Path("/myperson/")
/*@Produces("application/xml")
@Consumes("application/xml")*/
public class PersonService {

	PersonImpl personImpl;
//http://localhost:8082/restSpring/myperson/persons
	@GET
	@Path("/persons")
	@Produces({"application/xml","application/json"})
	/*public List<Person> getPersons() {
		IPersonWS pws = null;
		try {
			pws = (IPersonWS)ServiceUtil.findService(IPersonWS.class, "cxfPerson");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pws.getPersons();
		//return new PersonCollection(personImpl.selectAll());
	}*/
	public PersonCollection getPersons() {
		IPersonWS pws = null;
		try {
			pws = (IPersonWS)ServiceUtil.findService(IPersonWS.class, "cxfPerson");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pws.getPersons();
		//return new PersonCollection(personImpl.selectAll());
	}

	@POST
	@Path("/person1")
	@Produces({"application/xml","application/json"})
	public Person getPersonByIdObj(Person p) {
		Person p_ = personImpl.findById(p);
		return p_;
	}

	@GET
	@Path("/person/{id}")
	@Produces({"application/xml","application/json"})
	public Person getPersonById(@PathParam("id") long id) {
		Person p = new Person();
		p.setId(id);
		Person p_ = personImpl.findById(p);
		return p_;
	}
	@POST
	@Path("/addPerson")
	@Produces({"application/xml","application/json"})
	public String createPerson(Person p) {
		personImpl.create(p);
		return "ok";
	}

	@PUT
	@Path("/deletePerson")
	@Produces({"application/xml","application/json"})
	public String deletePerson(Person p) {
		personImpl.deleteById(p);
		return "ok";
	}

	@PUT
	@Path("/updatePerson")
	@Produces({"application/xml","application/json"})
	public String updatePerson(Person p) {
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
