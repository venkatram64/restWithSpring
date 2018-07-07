package com.venkat.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.srijan.Person;
import com.venkat.pojo.PersonCollection;
//javax.xml.bind.annotation.XmlNsForm.QUALIFIED
@WebService
@SOAPBinding(style=Style.RPC)

public interface IPersonWS {
	@WebMethod()
	@WebResult(name="Person",targetNamespace="")
	Person getPersonById(@WebParam(name="id") Long id);
	@WebMethod()
	@WebResult(name="Persons",targetNamespace="")
	PersonCollection getPersons();
	//List<Person> getPersons();
	@WebMethod()
	@WebResult(name="Person",targetNamespace="")
	Person getPersonByIdObj(@WebParam( name="person") Person p);
	@WebMethod()
	@WebResult(name="CreateStatus",targetNamespace="")
	String createPerson(@WebParam(name="person") Person p);
	@WebMethod()
	@WebResult(name="DeleteStatus",targetNamespace="")
	String deletePerson(@WebParam(name="person") Person p);
	@WebMethod()
	@WebResult(name="UpdateStatus",targetNamespace="")
	String updatePerson(@WebParam(name="person") Person p);
}
