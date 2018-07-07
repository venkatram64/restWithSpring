package com.srijan;

import java.io.Serializable;
import java.util.List;

import javax.sql.DataSource;

public interface IPersion extends Serializable{
	public void setDataSource(DataSource ds);
	public Person create(Person p);
	public List selectAll();
	public List select(Person p);
	public void deleteAll();
	public void delete(Person p);
	public void deleteById(Person id);
	public Person findById(Person id);
	public Person update(Person p);
}
