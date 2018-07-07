package com.srijan.ap.model;



public class APVillage implements java.io.Serializable{
	//id,dist_id,dist_name,mandal_id,mandal_name,village_id,village_name
	

	private long id;
	
	private long distId;
	
	private String distName;
	
	private long mandalId;
	
	private String mandalName;
	
	private long villageId;
	
	private String villageName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDistId() {
		return distId;
	}

	public void setDistId(long distId) {
		this.distId = distId;
	}

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
	}

	public long getMandalId() {
		return mandalId;
	}

	public void setMandalId(long mandalId) {
		this.mandalId = mandalId;
	}

	public String getMandalName() {
		return mandalName;
	}

	public void setMandalName(String mandalName) {
		this.mandalName = mandalName;
	}

	public long getVillageId() {
		return villageId;
	}

	public void setVillageId(long villageId) {
		this.villageId = villageId;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	
	

}
