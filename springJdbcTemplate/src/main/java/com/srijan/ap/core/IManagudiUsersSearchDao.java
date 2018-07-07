package com.srijan.ap.core;

import java.io.Serializable;
import java.util.List;

import com.srijan.ap.model.ManagudiUsers;

public interface IManagudiUsersSearchDao extends Serializable{
	public List<ManagudiUsers> searchManagudiUser(String category,String distName,String mandalName,String villageName);
	public List<ManagudiUsers> searchManagudiUsersAll();
}
