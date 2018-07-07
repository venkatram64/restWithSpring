package com.venkat.rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.venkat.ws.exception.UserException;


@Service("exceptionMapper")
@Provider
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class RestExceptionMapper implements ExceptionMapper<Exception> {
	
	private static Log LOG = LogFactory.getLog(RestExceptionMapper.class); 
	
	public Response toResponse(Exception exception) {
		  
		 if(exception instanceof UserException) { 
			 LOG.debug(exception.getMessage());  
			 return Response.status(Response.Status.OK).entity(exception).build();
		 }
		 
		 LOG.error(exception.getMessage(), exception); //Any exception is converted to internal server exception 
		 return Response.status(Response.Status.OK).entity(new Exception("Internal server error occurred. Please retry the operation.")).build();
	} 
}



