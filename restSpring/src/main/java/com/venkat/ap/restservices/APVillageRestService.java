package com.venkat.ap.restservices;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.stereotype.Service;

import com.srijan.ap.model.APVillage;
import com.srijan.ap.model.ManagudiUsers;
import com.venkat.annotations.ExtJSCompatibleResponse;
import com.venkat.ap.core.IAPVillageService;
import com.venkat.ap.core.IManagudiUsersSearchService;
import com.venkat.providers.ExtWrapper;
import com.venkat.util.ServiceUtil;
import com.venkat.ws.exception.UserException;

@Service("apVillageRestService")
@CrossOriginResourceSharing(allowAllOrigins = true,allowHeaders="*",allowOrigins="*",
allowCredentials = true,exposeHeaders="GET, POST, PUT, DELETE")
@Produces( { MediaType.APPLICATION_JSON })
@Consumes( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_FORM_URLENCODED })
@Path("/villages") 
public class APVillageRestService implements Serializable{
	private static Log LOG = LogFactory.getLog(APVillageRestService.class); 
	//http://localhost:8082/restSpring/villages/allDistricts
	
	@GET
    @Path("/allDistricts") 
    @ExtJSCompatibleResponse
    public ExtWrapper<APVillage> getAllDistricts(){
		try{
			IAPVillageService villageS = (IAPVillageService) ServiceUtil.findService(IAPVillageService.class,"cxfVillage");
			List<APVillage> vlist = villageS.getDistricts();
			/*String jsonStr = getJSON(vlist);
			List<String> jsList = new ArrayList<String>(); 
			jsList.add(jsonStr);*/
			return new ExtWrapper<APVillage>(vlist, vlist.size()); 
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
    @Path("/allMandals") 
    @ExtJSCompatibleResponse
    public ExtWrapper<APVillage> getAllMandals(@QueryParam("districtId") long districtId){
		try{
			IAPVillageService villageS = (IAPVillageService) ServiceUtil.findService(IAPVillageService.class,"cxfVillage");
			List<APVillage> vlist = villageS.getMondalByDistrictId(districtId);
			return new ExtWrapper<APVillage>(vlist, vlist.size()); 
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
    @Path("/allVillages") 
    @ExtJSCompatibleResponse
    public ExtWrapper<APVillage> getAllVillages(@QueryParam("districtId") long districtId,@QueryParam("mandalId") long mondalId){
		try{
			IAPVillageService villageS = (IAPVillageService) ServiceUtil.findService(IAPVillageService.class,"cxfVillage");
			List<APVillage> vlist = villageS.getVillageByMandalId(districtId,mondalId);
			return new ExtWrapper<APVillage>(vlist, vlist.size()); 
		}catch(SOAPFaultException e) {
			throw new UserException(e.getMessage()); 
		} 
		catch (Exception e) {
			 LOG.error("Internal Server Error occurred while fetching users.", e);
			 throw new UserException("Internal Server error occurred."); 
		}
	}

	//http://localhost:8082/restSpring/villages/searchCategories
	//http://localhost:8082/restSpring/villages/searchCategories?
	//category=BAJANAMANDALI&distName=KHAMMAM&mandalName=YERRUPALEM
	//&villageName=BANIGANDLAPADU
	@GET
    @Path("/searchCategories") 
    @ExtJSCompatibleResponse
    public ExtWrapper<ManagudiUsers> searchCategories(@QueryParam("category") String category,
    		@QueryParam("distName") String distName,@QueryParam("mandalName") String mandalName,
    		@QueryParam("villageName") String villageName){
		try{
			LOG.debug("....searchCategories started.....");
			IManagudiUsersSearchService userSearch = (IManagudiUsersSearchService) ServiceUtil.findService(IManagudiUsersSearchService.class,"cxfManagudiUsers");
			List<ManagudiUsers> vlist = userSearch.searchManagudiUser(category.trim(), distName.trim(), mandalName.trim(), villageName.trim());
			LOG.debug("....searchCategories ended.....");
			return new ExtWrapper<ManagudiUsers>(vlist, vlist.size()); 
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
    @Path("/searchAllCategories") 
    @ExtJSCompatibleResponse
    public ExtWrapper<ManagudiUsers> searchAll(){
		try{
			LOG.debug("....searchCategories started.....");
			IManagudiUsersSearchService userSearch = (IManagudiUsersSearchService) ServiceUtil.findService(IManagudiUsersSearchService.class,"cxfManagudiUsers");
			List<ManagudiUsers> vlist = userSearch.searchManagudiUsersAll();
			LOG.debug("....searchCategories ended.....");
			return new ExtWrapper<ManagudiUsers>(vlist, vlist.size()); 
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
    @Path("/searchCategory") 
    @ExtJSCompatibleResponse
    public ExtWrapper<ManagudiUsers> getSearchCategories(@QueryParam("category") String category,
    		@QueryParam("distName") String distName,@QueryParam("mandalName") String mandalName,
    		@QueryParam("villageName") String villageName){
		try{
			LOG.debug("....searchCategories started.....");
			IAPVillageService userSearch = (IAPVillageService) ServiceUtil.findService(IAPVillageService.class,"cxfVillage");
			List<ManagudiUsers> vlist = userSearch.searchManagudiUser(category, distName, mandalName, villageName);
			LOG.debug("....searchCategories ended.....");
			return new ExtWrapper<ManagudiUsers>(vlist, vlist.size()); 
		}catch(SOAPFaultException e) {
			LOG.debug(e.getMessage());
			throw new UserException(e.getMessage()); 
		} 
		catch (Exception e) {
			 LOG.error("Internal Server Error occurred while fetching users.", e);
			 throw new UserException("Internal Server error occurred."); 
		}
	}
	//http://localhost:8888/restSpring/villages/searchCategoryId?callback=JSON_CALLBACK&
	//category=BAJANAMANDALI&distId=22&mandalId=46&villageId=12
	@GET
    @Path("/searchCategoryId") 
    @ExtJSCompatibleResponse
    public ExtWrapper<ManagudiUsers> getSearchCategoriesById(@QueryParam("category") String category,
    		@QueryParam("distId") String distId,@QueryParam("mandalId") String mandalId,
    		@QueryParam("villageId") String villageId){
		try{
			LOG.debug("....searchCategories started.....");
			IAPVillageService userSearch = (IAPVillageService) ServiceUtil.findService(IAPVillageService.class,"cxfVillage");
			List<ManagudiUsers> vlist = userSearch.searchManagudiUserById(category, distId, mandalId, villageId);
			LOG.debug("....searchCategories ended.....");
			return new ExtWrapper<ManagudiUsers>(vlist, vlist.size()); 
		}catch(SOAPFaultException e) {
			LOG.debug(e.getMessage());
			throw new UserException(e.getMessage()); 
		} 
		catch (Exception e) {
			 LOG.error("Internal Server Error occurred while fetching users.", e);
			 throw new UserException("Internal Server error occurred."); 
		}
	}
	
	private String getJSON(List<APVillage> returnList) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (APVillage c : returnList) {
			if (count > 0) {
				sb.append(", ");
			} 
			
			sb.append(" ['");
			sb.append(c.getDistId() );
			sb.append("','");
			//sb.append(c.getDistName()); 
			sb.append(StringEscapeUtils.escapeJavaScript(c.getDistName())); 
			sb.append("' ]");

			count++;
		}
		
		if (count <= 0) {
			return "[ " + "['-Select-',null,'']]";
		} else if (count == 1) {
			return "[ " + sb.toString() + " ]";
		} else {
			return "[ " + "['-Select-',null,'']," + sb.toString() + " ]";
		}
	}

}
