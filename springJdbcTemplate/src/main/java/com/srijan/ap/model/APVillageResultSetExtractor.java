package com.srijan.ap.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class APVillageResultSetExtractor implements ResultSetExtractor<APVillage>{

	public APVillage extractData(ResultSet rs) throws SQLException,
	DataAccessException {
		APVillage v = new APVillage();
		v.setVillageId(rs.getLong(1));
		v.setVillageName(rs.getString(2));
		return v;
	
	}
}
