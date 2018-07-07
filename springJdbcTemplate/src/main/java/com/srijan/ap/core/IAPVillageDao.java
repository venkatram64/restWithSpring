package com.srijan.ap.core;

import java.io.Serializable;
import java.util.List;

import com.srijan.ap.model.APVillage;
import com.srijan.ap.model.ManagudiUsers;

public interface IAPVillageDao extends Serializable{
	public List<APVillage> getDistricts();
	public List<APVillage> getMondalByDistrictId(long distId);
	public List<APVillage> getVillageByMandalId(long districtId,long mondalId);
	public List<ManagudiUsers> searchManagudiUser(String category,
			String distName,String mandalName,String villageName);
	public List<ManagudiUsers> searchManagudiUserById(String category,
			String distId,String mandalId,String villageId);
}
