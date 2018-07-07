package com.srijan.ap.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class ManagudiUsersResultSetExtractor implements ResultSetExtractor<ManagudiUsers>{

	public ManagudiUsers extractData(ResultSet rs) throws SQLException,
	DataAccessException {
		
		//id, managudi_id,Dept,Category,association_name,State,Dist," +
		//Mandal,Village,temple_name,name,designation,phone,email,createdDate
		ManagudiUsers m = new ManagudiUsers();
		m.setId(rs.getInt("id"));
		m.setManagudiId(rs.getString("managudi_id"));
		m.setDept(rs.getString("Dept"));
		m.setCategory(rs.getString("Category"));
		m.setAssociationName(rs.getString("association_name"));
		m.setState(rs.getString("State"));
		m.setDistName(rs.getString("Dist"));
		m.setMandalName(rs.getString("Mandal"));
		m.setVillageName(rs.getString("Village"));
		m.setTempleName(rs.getString("temple_name") == null ? "" : rs.getString("temple_name"));
		m.setName(rs.getString("name"));
		m.setDesignation(rs.getString("designation"));
		m.setPhone(rs.getDouble("phone"));
		m.setEmail(rs.getString("email"));
		/*m.setId(rs.getInt(1));
		m.setManagudiId(rs.getString(2));
		m.setDept(rs.getString(3));
		m.setCategory(rs.getString(4));
		m.setAssociationName(rs.getString(5));
		m.setState(rs.getString(6));
		m.setDistName(rs.getString(7));
		m.setMandalName(rs.getString(8));
		m.setVillageName(rs.getString(9));
		m.setTempleName(rs.getString(10) == null ? "" : rs.getString(10));
		m.setName(rs.getString(11));
		m.setDesignation(rs.getString(12));
		m.setPhone(rs.getDouble(13));
		m.setEmail(rs.getString(14));*/
		//m.setCreatedDate(rs.getDate(15));
		return m;
	
	}
}
