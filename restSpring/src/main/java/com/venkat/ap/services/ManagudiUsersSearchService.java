package com.venkat.ap.services;

import java.util.List;

import javax.jws.WebService;

import com.srijan.ap.core.IManagudiUsersSearchDao;
import com.srijan.ap.model.ManagudiUsers;
import com.venkat.ap.core.IManagudiUsersSearchService;

@SuppressWarnings("serial")
@WebService(endpointInterface = "com.venkat.ap.core.IManagudiUsersSearchService", serviceName = "ManagudiUsersSearchService")
public class ManagudiUsersSearchService implements IManagudiUsersSearchService{

	private IManagudiUsersSearchDao managudiUsersDao;
	
	public IManagudiUsersSearchDao getManagudiUsersDao() {
		return managudiUsersDao;
	}

	public void setManagudiUsersDao(IManagudiUsersSearchDao managudiUsersDao) {
		this.managudiUsersDao = managudiUsersDao;
	}

	@Override
	public List<ManagudiUsers> searchManagudiUser(String category,
			String distName, String mandalName, String villageName) {
		return this.getManagudiUsersDao().searchManagudiUser(category, distName,
				mandalName, villageName);
	}

	@Override
	public List<ManagudiUsers> searchManagudiUsersAll() {
		
		return this.getManagudiUsersDao().searchManagudiUsersAll();
	}

}
