package com.venkat.ws.exception;

public class UserException extends RuntimeException {
		  
	private static final long serialVersionUID = 1L;
 
	public UserException(String message, Exception exception) {
		 super(message);
		 super.setStackTrace(exception.getStackTrace());
	}
	
	public UserException(String message) {
		 super(message); 
	}
}
