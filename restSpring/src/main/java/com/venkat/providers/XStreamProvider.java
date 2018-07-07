package com.venkat.providers;

import java.io.Writer;

import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

@Service
public class XStreamProvider {
	public String getJson(Object obj, boolean dropRootNode) {
		 
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		
		if(dropRootNode) {
			//Write to JSON with the self-contained JSON driver dropping the root
			xstream = new XStream(new JsonHierarchicalStreamDriver() {
			    public HierarchicalStreamWriter createWriter(Writer writer) {
			        return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
			    }
			});
		} 
		
	    //xstream.setMode(XStream.NO_REFERENCES); 
		xstream.setMode(XStream.XPATH_RELATIVE_REFERENCES); 
		xstream.processAnnotations(obj.getClass());
	    return xstream.toXML(obj);
	}
	
	public String getJson(Object obj) {
		return getJson(obj, true);
	}
}
