package com.venkat.ap.restservices;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.stereotype.Service;

import com.srijan.ap.model.APTempManagudiUser;
import com.venkat.annotations.ExtJSCompatibleResponse;
import com.venkat.ap.core.IAPTempManagudiUsersService;
import com.venkat.providers.ExtWrapper;
import com.venkat.util.ServiceUtil;
import com.venkat.ws.exception.UserException;

@Service("apManagudiUsersRestService")
@CrossOriginResourceSharing(allowAllOrigins = true,allowHeaders="*",allowOrigins="*",
allowCredentials= true,exposeHeaders="GET, POST, PUT, DELETE")
@Produces( { MediaType.APPLICATION_JSON })
@Consumes( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_FORM_URLENCODED })
@Path("/managudiUsers") 
public class APManagudiUsersRestService implements Serializable{
	private static Log LOG = LogFactory.getLog(APManagudiUsersRestService.class);
	
	//angularjs
	@POST
	 @Path("/createOrUpdateUsersForNG")
	 @ExtJSCompatibleResponse 
	 public ExtWrapper<APTempManagudiUser> createOrUpdateForNG(
			 @FormParam("id") int id,
			 @FormParam("category") String catName, 
			 @FormParam("distId") String distName, 
			 @FormParam("mandalId") String mandalName,
			 @FormParam("villageId") String villageName,
			 @FormParam("templeName") String templeName,
			 @FormParam("name") String name,
			 @FormParam("email") String email,
			 @FormParam("phone") String phone) throws Exception {
		 
		 try{
			 APTempManagudiUser user = new APTempManagudiUser();
			 user.setCategory(catName);
			 user.setDistName(distName);
			 user.setMandalName(mandalName);
			 user.setVillageName(villageName);
			 user.setTempleName(templeName);
			 user.setName(name);
			 user.setEmail(email);
			 user.setPhone(phone);
			 
			 if(id != 0){
				 user.setId(id);
			 }
			 
			 IAPTempManagudiUsersService service = (IAPTempManagudiUsersService)
			 					ServiceUtil.findService(IAPTempManagudiUsersService.class,"cxfTempManagudiUsers");
			 List<APTempManagudiUser> userList = null;
			 if(id != 0){
				 userList = service.updateNG(user);
			 }else{
				 userList = service.createNG(user);
			 }
			 return new ExtWrapper<APTempManagudiUser>(userList,userList.size()); 
		 }catch(SOAPFaultException e) {
			LOG.debug(e.getMessage());
			throw new UserException(e.getMessage()); 
		} 
		catch (Exception e) {
			 LOG.error("Internal Server Error occurred while fetching users.", e);
			 throw new UserException("Internal Server error occurred."); 
		}
		 
	}
	
	
	//angularjs end
	
	
	 @POST
	 @Path("/createOrUpdateUsers")
	 @ExtJSCompatibleResponse 
	 public ExtWrapper<APTempManagudiUser> createOrUpdate(
			 @FormParam("id") int id,
			 @FormParam("catName") String catName, 
			 @FormParam("distName") String distName, 
			 @FormParam("mandalName") String mandalName,
			 @FormParam("villageName") String villageName,
			 @FormParam("templeName") String templeName,
			 @FormParam("name") String name,
			 @FormParam("email") String email,
			 @FormParam("phone") String phone) throws Exception {
		 
		 try{
			 APTempManagudiUser user = new APTempManagudiUser();
			 user.setCategory(catName);
			 user.setDistName(distName);
			 user.setMandalName(mandalName);
			 user.setVillageName(villageName);
			 user.setTempleName(templeName);
			 user.setName(name);
			 user.setEmail(email);
			 user.setPhone(phone);
			 
			 if(id != 0){
				 user.setId(id);
			 }
			 
			 IAPTempManagudiUsersService service = (IAPTempManagudiUsersService)
			 					ServiceUtil.findService(IAPTempManagudiUsersService.class,"cxfTempManagudiUsers");
			 List<APTempManagudiUser> userList = null;
			 if(id != 0){
				 userList = service.update(user);
			 }else{
				 userList = service.create(user);
			 }
			 return new ExtWrapper<APTempManagudiUser>(userList,userList.size()); 
		 }catch(SOAPFaultException e) {
			LOG.debug(e.getMessage());
			throw new UserException(e.getMessage()); 
		} 
		catch (Exception e) {
			 LOG.error("Internal Server Error occurred while fetching users.", e);
			 throw new UserException("Internal Server error occurred."); 
		}
		 
	}
	 
	 @POST
	 @Path("/approveUser")
	 @ExtJSCompatibleResponse 
	 public ExtWrapper<APTempManagudiUser> approveRecord(
			 @FormParam("id") int id,
			 @FormParam("catName") String catName, 
			 @FormParam("distName") String distName, 
			 @FormParam("mandalName") String mandalName,
			 @FormParam("villageName") String villageName,
			 @FormParam("templeName") String templeName,
			 @FormParam("name") String name,
			 @FormParam("email") String email,
			 @FormParam("phone") String phone) throws Exception {
		 try{
			 APTempManagudiUser user = new APTempManagudiUser();
			 user.setCategory(catName);
			 user.setDistName(distName);
			 user.setMandalName(mandalName);
			 user.setVillageName(villageName);
			 user.setTempleName(templeName);
			 user.setName(name);
			 user.setEmail(email);
			 user.setPhone(phone);
			 user.setId(id);
			 
			 IAPTempManagudiUsersService service = (IAPTempManagudiUsersService)
			 					ServiceUtil.findService(IAPTempManagudiUsersService.class,"cxfTempManagudiUsers");
			 
			 List<APTempManagudiUser> list = service.approve(user);
			 
			 return new ExtWrapper<APTempManagudiUser>(list,list.size()); 
		 }catch(SOAPFaultException e) {
			LOG.debug(e.getMessage());
			throw new UserException(e.getMessage()); 
		} 
		catch (Exception e) {
			 LOG.error("Internal Server Error occurred while fetching users.", e);
			 throw new UserException("Internal Server error occurred."); 
		}
	}
	 
	 @POST
	 @Path("/deleteUser")
	 @ExtJSCompatibleResponse 
	 public ExtWrapper<APTempManagudiUser> deleteRecord(
			 @FormParam("id") int id,
			 @FormParam("catName") String catName, 
			 @FormParam("distName") String distName, 
			 @FormParam("mandalName") String mandalName,
			 @FormParam("villageName") String villageName,
			 @FormParam("phone") String phone) throws Exception {
		 try{
			 IAPTempManagudiUsersService service = (IAPTempManagudiUsersService)
			 					ServiceUtil.findService(IAPTempManagudiUsersService.class,"cxfTempManagudiUsers");
			 service.delete(id);
			 APTempManagudiUser user = new APTempManagudiUser();
			 user.setCategory(catName);
			 user.setDistName(distName);
			 user.setMandalName(mandalName);
			 user.setVillageName(villageName);
			 user.setPhone(phone);
			 user.setId(id);
			 List<APTempManagudiUser> userList = service.searchByPhone(user);
			 return new ExtWrapper<APTempManagudiUser>(userList,userList.size()); 
		 }catch(SOAPFaultException e) {
			LOG.debug(e.getMessage());
			throw new UserException(e.getMessage()); 
		} 
		catch (Exception e) {
			 LOG.error("Internal Server Error occurred while fetching users.", e);
			 throw new UserException("Internal Server error occurred."); 
		}
	 }
	 
	 @GET
	 @Path("/searchUsers")
	 @ExtJSCompatibleResponse 
	 public ExtWrapper<APTempManagudiUser> searchUsers(
			 @FormParam("id") int id,
			 @FormParam("catName") String catName, 
			 @FormParam("distName") String distName, 
			 @FormParam("mandalName") String mandalName,
			 @FormParam("villageName") String villageName,
			 @FormParam("templeName") String templeName,
			 @FormParam("name") String name,
			 @FormParam("email") String email,
			 @FormParam("phone") String phone) throws Exception {
		 try{
			 APTempManagudiUser user = new APTempManagudiUser();
			 user.setCategory(catName);
			 user.setDistName(distName);
			 user.setMandalName(mandalName);
			 user.setVillageName(villageName);
			 user.setTempleName(templeName);
			 user.setName(name);
			 user.setEmail(email);
			 user.setPhone(phone);
			 user.setId(id);
			 
			 IAPTempManagudiUsersService service = (IAPTempManagudiUsersService)
			 					ServiceUtil.findService(IAPTempManagudiUsersService.class,"cxfTempManagudiUsers");
			 
			 List<APTempManagudiUser> userList = service.search(user);
			 return new ExtWrapper<APTempManagudiUser>(userList,userList.size()); 
		 }catch(SOAPFaultException e) {
			LOG.debug(e.getMessage());
			throw new UserException(e.getMessage()); 
		} 
		catch (Exception e) {
			 LOG.error("Internal Server Error occurred while fetching users.", e);
			 throw new UserException("Internal Server error occurred."); 
		}
	}
	 
	 @POST
	 @Path("/searchByPhone")
	 @ExtJSCompatibleResponse 
	 public ExtWrapper<APTempManagudiUser> searchUsersByPhone(
			 @FormParam("id") int id,
			 @FormParam("catName") String catName, 
			 @FormParam("distName") String distName, 
			 @FormParam("mandalName") String mandalName,
			 @FormParam("villageName") String villageName,
			 @FormParam("phone") String phone) throws Exception {
		 try{
			 APTempManagudiUser user = new APTempManagudiUser();
			 user.setCategory(catName);
			 user.setDistName(distName);
			 user.setMandalName(mandalName);
			 user.setVillageName(villageName);
			 user.setPhone(phone);
			 user.setId(id);
			 
			 IAPTempManagudiUsersService service = (IAPTempManagudiUsersService)
			 					ServiceUtil.findService(IAPTempManagudiUsersService.class,"cxfTempManagudiUsers");
			 
			 List<APTempManagudiUser> userList = service.searchByPhone(user);
			 return new ExtWrapper<APTempManagudiUser>(userList,userList.size()); 
		 }catch(SOAPFaultException e) {
			LOG.debug(e.getMessage());
			throw new UserException(e.getMessage()); 
		} 
		catch (Exception e) {
			 LOG.error("Internal Server Error occurred while fetching users.", e);
			 throw new UserException("Internal Server error occurred."); 
		}
	}
	 
	 @GET
	 @Path("/findAllUsers")
	 @ExtJSCompatibleResponse 
	 public ExtWrapper<APTempManagudiUser> findAll() throws Exception {
		 try{
			 IAPTempManagudiUsersService service = (IAPTempManagudiUsersService)
			 					ServiceUtil.findService(IAPTempManagudiUsersService.class,"cxfTempManagudiUsers");
			 
			 List<APTempManagudiUser> userList = service.findAll();
			 return new ExtWrapper<APTempManagudiUser>(userList,userList.size()); 
		 }catch(SOAPFaultException e) {
			LOG.debug(e.getMessage());
			throw new UserException(e.getMessage()); 
		} 
		catch (Exception e) {
			 LOG.error("Internal Server Error occurred while fetching users.", e);
			 throw new UserException("Internal Server error occurred."); 
		}
	}
}
