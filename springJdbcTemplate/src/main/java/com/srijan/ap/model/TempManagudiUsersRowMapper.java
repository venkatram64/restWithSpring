package com.srijan.ap.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TempManagudiUsersRowMapper implements RowMapper<APTempManagudiUser>,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1236318834208249360L;

	public APTempManagudiUser mapRow(ResultSet rs, int line) throws SQLException {
		TempManagudiUsersResultSetExtractor extractor = new TempManagudiUsersResultSetExtractor();
	    return extractor.extractData(rs);
	}
}
