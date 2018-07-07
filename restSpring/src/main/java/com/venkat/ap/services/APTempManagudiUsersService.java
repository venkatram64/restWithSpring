package com.venkat.ap.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.srijan.ap.core.IAPTempManagudiUsersDao;
import com.srijan.ap.model.APTempManagudiUser;
import com.venkat.ap.core.IAPTempManagudiUsersService;

@SuppressWarnings("serial")
@WebService(endpointInterface = "com.venkat.ap.core.IAPTempManagudiUsersService", serviceName = "APTempManagudiUsersService")
public class APTempManagudiUsersService implements IAPTempManagudiUsersService{

	private IAPTempManagudiUsersDao tempManagudiUsersDao;
	
	public IAPTempManagudiUsersDao getTempManagudiUsersDao() {
		return tempManagudiUsersDao;
	}

	public void setTempManagudiUsersDao(IAPTempManagudiUsersDao tempManagudiUsersDao) {
		this.tempManagudiUsersDao = tempManagudiUsersDao;
	}

	@Override
	@WebMethod
	public List<APTempManagudiUser> approve(APTempManagudiUser tempUser) {
		return tempManagudiUsersDao.approve(tempUser);
	}

	@Override
	@WebMethod
	public List<APTempManagudiUser> create(APTempManagudiUser tempUser) {
		return tempManagudiUsersDao.create(tempUser);
	}
	
	@Override
	@WebMethod
	public List<APTempManagudiUser> createNG(APTempManagudiUser tempUser) {
		return tempManagudiUsersDao.createNG(tempUser);
	}

	@Override
	@WebMethod
	public boolean delete(int tempUserId) {
		return tempManagudiUsersDao.delete(tempUserId);
	}

	@Override
	@WebMethod
	public List<APTempManagudiUser> search(APTempManagudiUser tempUser) {
		return tempManagudiUsersDao.search(tempUser);
	}
	
	@Override
	@WebMethod
	public List<APTempManagudiUser> searchByPhone(APTempManagudiUser tempUser){
		return tempManagudiUsersDao.searchByPhone(tempUser);
	}

	@Override
	@WebMethod
	public List<APTempManagudiUser> update(APTempManagudiUser tempUser) {
		return tempManagudiUsersDao.update(tempUser);
	}
	
	@Override
	@WebMethod
	public List<APTempManagudiUser> updateNG(APTempManagudiUser tempUser) {
		return tempManagudiUsersDao.updateNG(tempUser);
	}

	@Override
	@WebMethod
	public List<APTempManagudiUser> findAll() {
		return tempManagudiUsersDao.findAll();
	}

	
}
