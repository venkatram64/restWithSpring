package com.venkat.ap.core;

import java.io.Serializable;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.srijan.ap.model.APVillage;
import com.srijan.ap.model.ManagudiUsers;



@WebService 
@SOAPBinding(style = Style.RPC)
public interface IAPVillageService extends Serializable{ 
	
	public static final String SERVICE_NAME = "APVillageService";
	
	@WebMethod
	public List<APVillage> getDistricts(); 
	
	@WebMethod
	public List<APVillage> getMondalByDistrictId(long distId) ;
	
	@WebMethod
	public List<APVillage> getVillageByMandalId(long districtId,long mondalId) ;
	
	@WebMethod
	public List<ManagudiUsers> searchManagudiUser(String category,
			String distName,String mandalName,String villageName);
	
	@WebMethod
	public List<ManagudiUsers> searchManagudiUserById(String category,
			String distId,String mandalId,String villageId);

}

