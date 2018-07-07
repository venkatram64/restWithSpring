package com.srijan.ap.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class APVillageRowMapper implements RowMapper<APVillage>,Serializable{
	
	public APVillage mapRow(ResultSet rs, int line) throws SQLException {
		APVillageResultSetExtractor extractor = new APVillageResultSetExtractor();
	    return extractor.extractData(rs);
	}
}
