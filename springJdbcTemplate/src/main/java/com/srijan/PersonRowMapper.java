package com.srijan;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper<Person>,Serializable{

	
	public Person mapRow(ResultSet rs, int line) throws SQLException {
		PersonResultSetExtractor extractor = new PersonResultSetExtractor();
	    return extractor.extractData(rs);
	}

}
