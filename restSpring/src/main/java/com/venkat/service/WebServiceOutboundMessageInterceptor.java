package com.venkat.service;

import java.io.OutputStream;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CacheAndWriteOutputStream;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.io.CachedOutputStreamCallback;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class WebServiceOutboundMessageInterceptor extends AbstractPhaseInterceptor{

	public WebServiceOutboundMessageInterceptor() {
		super(Phase.PRE_STREAM);
	}
	
	public void handleMessage(Message message) throws Fault {
		OutputStream os = (OutputStream)message.getContent(OutputStream.class);
		if(os == null)
		    return;
		final CacheAndWriteOutputStream newOut = new CacheAndWriteOutputStream(os);
		message.setContent(OutputStream.class, newOut);
		newOut.registerCallback(new LoggingCallback()); 
	}
	
	
	/**
	 * Logging callback classs which caches and 
         * writes the soap envelope to a StringBuilder.
	 */
	class LoggingCallback implements CachedOutputStreamCallback {
            public void onFlush(CachedOutputStream cos) {
            }
            public void onClose(CachedOutputStream cos) {
                try {
            	    StringBuilder buffer = new StringBuilder();
            	    cos.writeCacheTo(buffer);
            	    //print buffer - and now i see the full soap envelope
                }catch (Exception e) {
                }
            }
	} 
}
