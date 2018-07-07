package com.venkat.providers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.interceptor.security.AccessDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.BigIntegerConverter;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.converters.basic.DoubleConverter;
import com.thoughtworks.xstream.converters.basic.FloatConverter;
import com.thoughtworks.xstream.converters.basic.IntConverter;
import com.thoughtworks.xstream.converters.basic.LongConverter;
import com.thoughtworks.xstream.converters.basic.ShortConverter;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.venkat.annotations.Alias;
import com.venkat.annotations.Deserialize;
import com.venkat.annotations.ExcludeJSONConversion;
import com.venkat.annotations.ExtJSCompatibleResponse;
import com.venkat.ws.exception.UserException;

@Service("jsonBodyReaderWriter")
public class JsonBodyReaderWriter implements MessageBodyWriter<Object>, MessageBodyReader<Object> {
	
	private static Log log = LogFactory.getLog(JsonBodyReaderWriter.class.getName());
	
	@Autowired XStreamProvider jsonProvider;
  
	public boolean isReadable(Class<?> clazz, Type type, Annotation[] annotations, MediaType  mediaType) {
		return true;
	} 
	 
	public Object readFrom(Class<Object> clazz, Type type, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap<String, String> multiValuedMap,
			InputStream inputStream) throws IOException, WebApplicationException {
		
		XStream xstream = new XStream(new JettisonMappedXmlDriver()); 
	    xstream.setMode(XStream.NO_REFERENCES); 
	    xstream.registerConverter(new CustomIntegerConverter());
	    xstream.registerConverter(new CustomShortConverter());
	    xstream.registerConverter(new CustomLongConverter());
	    xstream.registerConverter(new CustomDoubleConverter());
	    xstream.registerConverter(new CustomFloatConverter());
	    xstream.registerConverter(new CustomBooleanConverter());
	    xstream.registerConverter(new CustomDateConverter());
	    xstream.registerConverter(new CustomBigIntegerConverter());
	    
	    
	    Deserialize deserialize = (Deserialize) findAnnotation( Deserialize.class, annotations );
        if( deserialize != null ){
        	for(Alias alias : deserialize.aliases()) {
        		xstream.alias(alias.alias(), alias.clazz());
        	}
        } 
	     
	    try {
	    	return xstream.fromXML(inputStream); 
	    }
	    catch(Exception e) {
	    	log.error( "Error Deserializing ", e );
	        throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR );
	    }  
	}
	
	protected Annotation findAnnotation( Class<? extends Annotation> clazz, Annotation[] annotations ){
        for( Annotation a : annotations ){
            if( clazz.isAssignableFrom( a.getClass() ) ){
                return a;
            }
        }
        return null;
    }
	
	public String convertStreamToString(InputStream is) throws IOException {
       
        if (is != null) {
            StringBuilder sb = new StringBuilder();
            String line;

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            } finally {
                is.close();
            }
            return sb.toString();
        } 
        else {        
            return "";
        }
    } 
	
	public class CustomIntegerConverter extends IntConverter {
		
		@Override
		public Object fromString(String str) {
	    	if(str == null || str.trim().equals("")) {
	    		return new Integer(0);
	    	}
	    	return super.fromString(str);
	    } 
	}
	
	public class CustomShortConverter extends ShortConverter {
		
		@Override
		public Object fromString(String str) {
	    	if(str == null || str.trim().equals("")) {
	    		return null;
	    	}
	    	return super.fromString(str);
	    } 
	}
	
	public class CustomLongConverter extends LongConverter {
		
		@Override
		public Object fromString(String str) {
	    	if(str == null || str.trim().equals("")) {
	    		return null;
	    	}
	    	return super.fromString(str);
	    } 
	}
	
	public class CustomDoubleConverter extends DoubleConverter {
		
		@Override
		public Object fromString(String str) {
	    	if(str == null || str.trim().equals("")) {
	    		return null;
	    	}
	    	return super.fromString(str);
	    } 
	}
	
	public class CustomFloatConverter extends FloatConverter {
		
		@Override
		public Object fromString(String str) {
	    	if(str == null || str.trim().equals("")) {
	    		return null;
	    	}
	    	return super.fromString(str);
	    } 
	}
	
	public class CustomBooleanConverter extends BooleanConverter {
		
		@Override
		public Object fromString(String str) {
	    	if(str == null || str.trim().equals("")) {
	    		return null;
	    	}
	    	return super.fromString(str);
	    } 
	}
	
	public class CustomDateConverter extends DateConverter {
		
		@Override
		public Object fromString(String str) {
	    	if(str == null || str.trim().equals("")) {
	    		return null;
	    	}
	    	return super.fromString(str);
	    } 
	}
	
	public class CustomBigIntegerConverter extends BigIntegerConverter {
		
		@Override
		public Object fromString(String str) {
	    	if(str == null || str.trim().equals("")) {
	    		return null;
	    	}
	    	return super.fromString(str);
	    } 
	}
	
	
	// JSON BODY WRITER SPECIFIC METHODS....
	public long getSize(Object o, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }
	
    public boolean isWriteable(Class<?> clazz, Type genericType, Annotation[] annotations, MediaType mediaType) {
    	//if(findAnnotation( ExtJSCompatibleResponse.class, annotations ) != null) { //Only use this customer writer if EXT-JS output is needed..
    	//	return true;
    	//}
        //return false;
    	return true;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void writeTo(Object o, Class<?> type, Type genericType, Annotation[] annotations,
             MediaType mediaType, MultivaluedMap<String,Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
    	
    	if(findAnnotation( ExtJSCompatibleResponse.class, annotations ) != null) { //Only use this customer writer if EXT-JS output is needed..
	    	ExtWrapper wrapper = new ExtWrapper(); 
			
			if(o == null) {
				wrapper.setData(new LinkedList());
				wrapper.setTotal(wrapper.getData().size());
			}
			else {
		    	if(o instanceof Exception) { //Handle exceptions
		    		handleExceptions(o, entityStream);
					return;
		        } 
		    	
				if( o instanceof List ){
					wrapper.setData((List) o);
					wrapper.setTotal(wrapper.getData().size());
				}
				else if(o instanceof ExtWrapper) { //this will be used with pagination to set total value to the actual number 
					//of records in the database..not the size of the list.. so the ExtWrapper object itself would be returned by the rest service..
					//which will contain total property already...
					wrapper = (ExtWrapper) o; 
				}
				else {
					List list = new LinkedList();
					list.add(o);
					wrapper.setData(list);
					wrapper.setTotal(wrapper.getData().size());
				} 
			}
			
			wrapper.setMessage("Success");
			wrapper.setSuccess(true);
			
			entityStream.write( jsonProvider.getJson(wrapper).getBytes() ); 
    	}
    	else if(findAnnotation( ExcludeJSONConversion.class, annotations ) != null) { 
    		entityStream.write(((String)o).getBytes()); 
    	}
    	else { //Regular non ext-js response expected from client
    		entityStream.write( jsonProvider.getJson(o).getBytes() ); 
    	} 
	}

	private void handleExceptions(Object o, OutputStream entityStream) throws IOException {
		if(o instanceof AccessDeniedException) { //spring security auth exception
			 log.debug(((AccessDeniedException)o).getMessage());
			 
			 ExtWrapper<AccessDeniedException> wrapper = new ExtWrapper<AccessDeniedException>(); 
			 wrapper.setMessage(((AccessDeniedException)o).getMessage());
			 wrapper.setSuccess(false);  
		     
			 entityStream.write( jsonProvider.getJson(wrapper).getBytes() );
			 return;
		 }
		 
		 if(o instanceof UserException) { //spring security auth exception 
			 ExtWrapper<UserException> wrapper = new ExtWrapper<UserException>(); 
			 wrapper.setMessage(((UserException)o).getMessage());
			 wrapper.setSuccess(false);  
		     
			 entityStream.write( jsonProvider.getJson(wrapper).getBytes() );
			 return;
		 }
		 
		 log.error(((Exception) o).getMessage()); //Any exception is converted to internal server exception 
		 ExtWrapper<Exception> wrapper = new ExtWrapper<Exception>(); 
		 wrapper.setMessage(((Exception)o).getMessage());
		 wrapper.setSuccess(false);  
		 
		 entityStream.write( jsonProvider.getJson(wrapper).getBytes() );
		 return;
	} 
}
