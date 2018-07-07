package com.venkat.ap.services;

import java.util.List;

import javax.jws.WebService;

import com.srijan.ap.core.IAPVillageDao;
import com.srijan.ap.model.APVillage;
import com.srijan.ap.model.ManagudiUsers;
import com.venkat.ap.core.IAPVillageService;

@SuppressWarnings("serial")
@WebService(endpointInterface = "com.venkat.ap.core.IAPVillageService", serviceName = "APVillageService")
public class APVillageSerevice  implements IAPVillageService{

	private IAPVillageDao apVillageDao;
	
	public IAPVillageDao getApVillageDao() {
		return apVillageDao;
	}

	public void setApVillageDao(IAPVillageDao apVillageDao) {
		this.apVillageDao = apVillageDao;
	}

	@Override
	public List<APVillage> getDistricts() {
		return apVillageDao.getDistricts();
	}

	@Override
	public List<APVillage> getMondalByDistrictId(long distId) {
		return apVillageDao.getMondalByDistrictId(distId);
	}

	@Override
	public List<APVillage> getVillageByMandalId(long districtId,long mondalId) {
		return apVillageDao.getVillageByMandalId(districtId,mondalId);
	}
	
	@Override
	public List<ManagudiUsers> searchManagudiUser(String category,
			String distName,String mandalName,String villageName){
		return apVillageDao.searchManagudiUser(category, distName, mandalName, villageName);
	}

	public List<ManagudiUsers> searchManagudiUserById(String category,
			String distId,String mandalId,String villageId){
		return apVillageDao.searchManagudiUserById(category, distId, mandalId, villageId);
	}

}
