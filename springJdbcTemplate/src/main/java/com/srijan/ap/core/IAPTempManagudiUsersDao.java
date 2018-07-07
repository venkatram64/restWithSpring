package com.srijan.ap.core;

import java.io.Serializable;
import java.util.List;

import com.srijan.ap.model.APTempManagudiUser;

public interface IAPTempManagudiUsersDao extends Serializable{

	public List<APTempManagudiUser> create(APTempManagudiUser tempUser);
	public List<APTempManagudiUser> update(APTempManagudiUser tempUser);
	public List<APTempManagudiUser> createNG(APTempManagudiUser tempUser);
	public List<APTempManagudiUser> updateNG(APTempManagudiUser tempUser);
	public boolean delete(int tempUserId);
	public List<APTempManagudiUser> search(APTempManagudiUser tempUser);
	public List<APTempManagudiUser> searchByPhone(APTempManagudiUser tempUser);
	public List<APTempManagudiUser> approve(APTempManagudiUser tempUser);
	public List<APTempManagudiUser> findAll();
}
