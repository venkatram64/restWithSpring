package com.srijan.ap.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.srijan.ap.core.IManagudiUsersSearchDao;
import com.srijan.ap.model.ManagudiUsers;
import com.srijan.ap.model.ManagudiUsersRowMapper;

public class ManagudiUsersSearchDao implements IManagudiUsersSearchDao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7116839195350138242L;

	private static Log LOG = LogFactory.getLog(ManagudiUsersSearchDao.class);
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<ManagudiUsers> searchManagudiUser(String category,
			String distName, String mandalName, String villageName) {
		LOG.debug("I am here...");
		String sql = "SELECT * FROM managudi_users where Category = ? and Dist = ? and Mandal = ? and Village = ?";
		Object[] params = new Object[] {category, distName,mandalName,villageName };
		return this.jdbcTemplate.query(sql,params, new ManagudiUsersRowMapper());
	}

	@Override
	public List<ManagudiUsers> searchManagudiUsersAll() {
		String sql = "SELECT * FROM managudi_users";
		return this.jdbcTemplate.query(sql, new ManagudiUsersRowMapper());
	}

}
