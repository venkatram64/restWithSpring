package com.srijan;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonImpl implements IPersion {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub

	}

	public Person create(Person p) {
		String sql = "insert into users(firstName,lastName) values(?,?)";
		Object[] params = new Object[] { p.getFirstName(), p.getLastName() };
		getJdbcTemplate().update(sql, params);
		System.out.println("Person object is created successfully...");
		return p;
	}

	public List selectAll() {
		String sql = "select id, firstName, lastName from users";
		return this.getJdbcTemplate().query(sql, new PersonRowMapper());
	}

	public List select(Person p) {
		String sql = "select  id,firstName, lastName from users where firstName = ? AND lastName= ?";
		Object[] params = new Object[] { p.getFirstName(), p.getLastName() };
		return this.getJdbcTemplate().query(sql, params, new PersonRowMapper());
	}

	public void deleteAll() {
		String sql = "delete from person";
		this.getJdbcTemplate().update(sql);
	}

	public void delete(Person p) {
		String sql = "delete from users  where firstName = ? AND lastName= ?";
		Object[] params = new Object[] { p.getFirstName(), p.getLastName() };
		this.getJdbcTemplate().update(sql, params);
	}

	public void deleteById(Person p) {
		String sql = "delete from users  where id = ?";
		Object[] params = new Object[] { p.getId() };
		this.getJdbcTemplate().update(sql, params);

	}

	public Person findById(Person p) {
		System.out.println("*************** id is " + p.getId());
		String sql = "select  id, firstName, lastName from users where id = ?";
		Object[] params = new Object[] { p.getId() };
		return this.getJdbcTemplate().queryForObject(sql, params, new PersonRowMapper());
	}
	
	public Person update(Person p){
		String sql = "update users set firstName = ?, lastName = ? where id = ?" ;
		Object[] params = new Object[] { p.getFirstName(),p.getLastName(),p.getId()};
		this.getJdbcTemplate().update(sql, params);
		return new Person();
	}

}
