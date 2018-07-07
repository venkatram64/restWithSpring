package com.srijan.ap.model;

import java.io.Serializable;

public class APTempManagudiUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1525818734039840382L;
	
	private int id;
	private String category;
	private String distName;
	private String mandalName;
	private String villageName;
	private String templeName;
	private String name;
	private String email;
	private String phone;
	private int approved;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDistName() {
		return distName;
	}
	public void setDistName(String distName) {
		this.distName = distName;
	}
	public String getMandalName() {
		return mandalName;
	}
	public void setMandalName(String mandalName) {
		this.mandalName = mandalName;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public String getTempleName() {
		return templeName;
	}
	public void setTempleName(String templeName) {
		this.templeName = templeName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int isApproved() {
		return approved;
	}
	public void setApproved(int approved) {
		this.approved = approved;
	}
	
}
