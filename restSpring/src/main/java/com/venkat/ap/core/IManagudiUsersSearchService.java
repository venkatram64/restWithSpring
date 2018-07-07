package com.venkat.ap.core;

import java.io.Serializable;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.srijan.ap.model.ManagudiUsers;

@WebService 
@SOAPBinding(style = Style.RPC)
public interface IManagudiUsersSearchService extends Serializable{
	public static final String SERVICE_NAME = "ManagudiUsersSearchService";
	
	@WebMethod
	public List<ManagudiUsers> searchManagudiUser(String category,
			String distName,String mandalName,String villageName);
	
	@WebMethod
	public List<ManagudiUsers> searchManagudiUsersAll();

}
