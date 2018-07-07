package com.srijan.ap.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.srijan.ap.core.IAPTempManagudiUsersDao;
import com.srijan.ap.model.APDistrictRowMapper;
import com.srijan.ap.model.APMandalRowMapper;
import com.srijan.ap.model.APTempManagudiUser;
import com.srijan.ap.model.APVillage;
import com.srijan.ap.model.APVillageRowMapper;
import com.srijan.ap.model.TempManagudiUsersRowMapper;

public class APTempManagudiUsersDao implements IAPTempManagudiUsersDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1831395471363208727L;
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<APTempManagudiUser> createNG(APTempManagudiUser tempUser) {
		String inserQuery = "insert into temp_managudi_users (category, dist_name, mandal_name ," +
				" village_name,temple_name,name,email,phone) " +
				"values (?, ?, ?, ?,?, ?, ?, ?) ";
		
		String distName = getDistName(Long.parseLong(tempUser.getDistName()));
		String mondalName = getMandalName(Long.parseLong(tempUser.getDistName()),Long.parseLong(tempUser.getMandalName()));
		String villageName = getVillageName(Long.parseLong(tempUser.getDistName()),Long.parseLong(tempUser.getMandalName()),
				Long.parseLong(tempUser.getVillageName()));
		
		Object[] params = new Object[] {tempUser.getCategory(),distName,
				mondalName, villageName,tempUser.getTempleName(),
				tempUser.getName(),tempUser.getEmail(),tempUser.getPhone()};
		
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR};
		
		jdbcTemplate.update(inserQuery, params, types);
		return searchByPhone(tempUser);
	}
	
	@Override
	public List<APTempManagudiUser> updateNG(APTempManagudiUser tempUser) {
		String updateQuery = "update temp_managudi_users set category=? ,dist_name=?" +
				",mandal_name=?,village_name=?,temple_name=?,name=?, email=?,phone=?where id = ?";
		
		String distName = getDistName(Long.parseLong(tempUser.getDistName()));
		String mondalName = getMandalName(Long.parseLong(tempUser.getDistName()),Long.parseLong(tempUser.getMandalName()));
		String villageName = getVillageName(Long.parseLong(tempUser.getDistName()),Long.parseLong(tempUser.getMandalName()),
				Long.parseLong(tempUser.getVillageName()));
		
		Object[] params = new Object[] {tempUser.getCategory(),distName,
				mondalName, villageName,tempUser.getTempleName(),
				tempUser.getName(),tempUser.getEmail(),tempUser.getPhone(),tempUser.getId()};
		jdbcTemplate.update(updateQuery, params);
		return searchByPhone(tempUser);
	}
	
	@Override
	public List<APTempManagudiUser> create(APTempManagudiUser tempUser) {
		String inserQuery = "insert into temp_managudi_users (category, dist_name, mandal_name ," +
				" village_name,temple_name,name,email,phone) " +
				"values (?, ?, ?, ?,?, ?, ?, ?) ";
		
				
		Object[] params = new Object[] {tempUser.getCategory(),tempUser.getDistName(),
				tempUser.getMandalName(), tempUser.getVillageName(),tempUser.getTempleName(),
				tempUser.getName(),tempUser.getEmail(),tempUser.getPhone()};
		
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR};
		
		jdbcTemplate.update(inserQuery, params, types);
		return searchByPhone(tempUser);
	}
	
	@Override
	public List<APTempManagudiUser> update(APTempManagudiUser tempUser) {
		String updateQuery = "update temp_managudi_users set category=? ,dist_name=?" +
				",mandal_name=?,village_name=?,temple_name=?,name=?, email=?,phone=?where id = ?";
						
		Object[] params = new Object[] {tempUser.getCategory(),tempUser.getDistName(),
				tempUser.getMandalName(), tempUser.getVillageName(),tempUser.getTempleName(),
				tempUser.getName(),tempUser.getEmail(),tempUser.getPhone(),tempUser.getId()};
		jdbcTemplate.update(updateQuery, params);
		return searchByPhone(tempUser);
	}

	@Override
	public boolean delete(int tempUserId) {
		String delQuery = "delete from temp_managudi_users where id = ?";
		int count = jdbcTemplate.update(delQuery, new Object[] { tempUserId });
		if(count!=0){
			System.out.println("temp_managudi_users deleted successfully.");
			return true;
		}
		else{
			System.out.println("Couldn't delete temp_managudi_users with given id as it doesn't exist");
			return false;
		}
	}

	@Override
	public List<APTempManagudiUser> search(APTempManagudiUser tempUser) {
		String sql = "SELECT id,category,dist_name,mandal_name,village_name,temple_name," +
				"name,email,phone FROM temp_managudi_users where category = ? " +
				"and dist_name = ? and mandal_name = ? and village_name=? and" +
				" name = ? and email = ? and phone = ? and approved = ?";
		Object[] params = new Object[] {tempUser.getCategory(), tempUser.getDistName(),
				tempUser.getMandalName(),tempUser.getVillageName(), tempUser.getName(),
				tempUser.getEmail(), tempUser.getPhone(),0};
		return this.getJdbcTemplate().query(sql,params, new TempManagudiUsersRowMapper());
	}

	private List<APTempManagudiUser> updateApproval(APTempManagudiUser tempUser) {
		String updateQuery = "update temp_managudi_users set approved=? where id = ?";
		
		Object[] params = new Object[] {1,tempUser.getId()};
		jdbcTemplate.update(updateQuery, params);
		return searchByPhone(tempUser);
	}
	
	@Override
	public List<APTempManagudiUser> approve(APTempManagudiUser tempUser) {
		String inserQuery = "insert into managudi_users (managudi_id, Dept,Category,association_name," +
				"State,Dist, Mandal,Village,temple_name,name,designation,phone,email,createdDate) " +
		"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?) ";

		Object[] params = new Object[] {tempUser.getId() + "","Dept",tempUser.getCategory(),"","Andhra Pradesh",tempUser.getDistName(),
				tempUser.getMandalName(), tempUser.getVillageName(),tempUser.getTempleName(),
				tempUser.getName(),"",tempUser.getPhone(),tempUser.getEmail(),new Date()};
		
		/*int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR};*/
		
		int re = jdbcTemplate.update(inserQuery, params);
		if(re != 0){
			return updateApproval(tempUser);
		}
		return new ArrayList<APTempManagudiUser>();
	}

	@Override
	public List<APTempManagudiUser> searchByPhone(APTempManagudiUser tempUser) {
		String sql = "SELECT id,category,dist_name,mandal_name,village_name,temple_name," +
		"name,email,phone FROM temp_managudi_users where category = ? " +
		"and dist_name = ? and mandal_name = ? and village_name=? and" +
		" phone = ? and approved = ?";
	Object[] params = new Object[] {tempUser.getCategory(), tempUser.getDistName(),
			tempUser.getMandalName(),tempUser.getVillageName(), tempUser.getPhone(),0};
	return this.getJdbcTemplate().query(sql,params, new TempManagudiUsersRowMapper());
	}

	@Override
	public List<APTempManagudiUser> findAll() {
		String sql = "SELECT id,category,dist_name,mandal_name,village_name,temple_name," +
		"name,email,phone FROM temp_managudi_users where approved = 0";
		return this.getJdbcTemplate().query(sql, new TempManagudiUsersRowMapper());
	}
	
	private String getDistName(long distId){
		String strQuery ="SELECT DISTINCT dist_id,dist_name FROM apvillages WHERE dist_id = ?";
		Object[] params = new Object[] { distId };
		List<APVillage> distList = this.getJdbcTemplate().query(strQuery,params, new APDistrictRowMapper());
		APVillage ap = distList.get(0);
		return ap.getDistName();
	}
	
	private String getMandalName(long distId,long manId){
		String strQuery ="SELECT DISTINCT mandal_id,mandal_name FROM apvillages WHERE dist_id = ? and mandal_id = ?";
		Object[] params = new Object[] {distId, manId };
		List<APVillage> distList = this.getJdbcTemplate().query(strQuery,params, new APMandalRowMapper() );
		APVillage ap = distList.get(0);
		return ap.getMandalName();
	}
	
	private String getVillageName(long distId,long manId,long villageId){
		String strQuery ="SELECT DISTINCT village_id,village_name FROM apvillages WHERE dist_id = ? and mandal_id = ? and village_id = ?";
		Object[] params = new Object[] {distId,manId,villageId };
		List<APVillage> distList = this.getJdbcTemplate().query(strQuery,params, new APVillageRowMapper());
		APVillage ap = distList.get(0);
		return ap.getVillageName();
	}

}
