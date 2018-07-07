package com.srijan.ap.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class TempManagudiUsersResultSetExtractor implements ResultSetExtractor<APTempManagudiUser>{

	public APTempManagudiUser extractData(ResultSet rs) throws SQLException,
	DataAccessException {
		
		APTempManagudiUser m = new APTempManagudiUser();
		m.setId(rs.getInt("id"));
		
		m.setCategory(rs.getString("category"));
		m.setDistName(rs.getString("dist_name"));
		m.setMandalName(rs.getString("mandal_name"));
		m.setVillageName(rs.getString("village_name"));
		m.setTempleName(rs.getString("temple_name"));
		m.setName(rs.getString("name"));
		m.setPhone(rs.getString("phone"));
		m.setEmail(rs.getString("email"));
		
		return m;
	
	}
}
