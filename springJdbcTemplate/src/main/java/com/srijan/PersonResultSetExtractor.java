package com.srijan;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class PersonResultSetExtractor implements ResultSetExtractor<Person>{

	
	public Person extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		Person person = new Person();
		person.setId(rs.getInt(1));
	    person.setFirstName(rs.getString(2));
	    person.setLastName(rs.getString(3));
	    return person;

	}

}
