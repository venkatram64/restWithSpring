package com.srijan.ap.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ManagudiUsersRowMapper implements RowMapper<ManagudiUsers>,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1236318834208249360L;

	public ManagudiUsers mapRow(ResultSet rs, int line) throws SQLException {
		ManagudiUsersResultSetExtractor extractor = new ManagudiUsersResultSetExtractor();
	    return extractor.extractData(rs);
	}
}
