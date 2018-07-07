package com.venkat.providers;

import java.util.List;
 
public class ExtWrapper<E> {
	
	private boolean success = true;
	private String message;
	private int total; 
	private List<E> data; 
	
	public ExtWrapper() {
		
	}
	 
	public ExtWrapper(List<E> data, int total) {
		this.data = data;
		this.total = total;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<E> getData() {
		return data;
	}
	public void setData(List<E> data) {
		this.data = data;
	}  
}



