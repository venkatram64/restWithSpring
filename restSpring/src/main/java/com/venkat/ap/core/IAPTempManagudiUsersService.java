package com.venkat.ap.core;

import java.io.Serializable;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.srijan.ap.model.APTempManagudiUser;

@WebService 
@SOAPBinding(style = Style.RPC)
public interface IAPTempManagudiUsersService extends Serializable{
	public static final String SERVICE_NAME = "APTempManagudiUsersService";
	
	@WebMethod
	public List<APTempManagudiUser> createNG(APTempManagudiUser tempUser);
	
	@WebMethod
	public List<APTempManagudiUser> updateNG(APTempManagudiUser tempUser);
	
	@WebMethod
	public List<APTempManagudiUser> create(APTempManagudiUser tempUser);
	
	@WebMethod
	public List<APTempManagudiUser> update(APTempManagudiUser tempUser);
	
	@WebMethod
	public boolean delete(int tempUserId);
	
	@WebMethod
	public List<APTempManagudiUser> search(APTempManagudiUser tempUser);
	
	@WebMethod
	public List<APTempManagudiUser> searchByPhone(APTempManagudiUser tempUser);
	
	@WebMethod
	public List<APTempManagudiUser> approve(APTempManagudiUser tempUser);
	
	@WebMethod
	public List<APTempManagudiUser> findAll();
}
