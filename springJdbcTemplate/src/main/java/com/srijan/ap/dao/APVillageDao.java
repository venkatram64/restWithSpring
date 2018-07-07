package com.srijan.ap.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.srijan.ap.core.IAPVillageDao;
import com.srijan.ap.model.APDistrictRowMapper;
import com.srijan.ap.model.APMandalRowMapper;
import com.srijan.ap.model.APVillage;
import com.srijan.ap.model.APVillageRowMapper;
import com.srijan.ap.model.ManagudiUsers;
import com.srijan.ap.model.ManagudiUsersRowMapper;

public class APVillageDao implements IAPVillageDao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7445510269504045804L;
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<APVillage> getDistricts(){
		String strQuery ="SELECT DISTINCT dist_id,dist_name FROM apvillages";
		return this.getJdbcTemplate().query(strQuery, new APDistrictRowMapper());
		
	}
	
	public List<APVillage> getMondalByDistrictId(long distId){//
		String strQuery ="SELECT DISTINCT mandal_id,mandal_name FROM apvillages WHERE dist_id = ?";
		Object[] params = new Object[] { distId };
		return this.getJdbcTemplate().query(strQuery,params, new APMandalRowMapper());
	}
	
	public List<APVillage> getVillageByMandalId(long districtId,long mondalId){
		String strQuery ="SELECT DISTINCT village_id,village_name FROM apvillages WHERE dist_id = ? and mandal_id = ?";
		Object[] params = new Object[] {districtId, mondalId };
		return this.getJdbcTemplate().query(strQuery,params, new APVillageRowMapper());
	}

	public List<ManagudiUsers> searchManagudiUser(String category,
			String distName, String mandalName, String villageName) {
		String sql = "SELECT id, managudi_id,Dept,Category,association_name,State,Dist," +
		"Mandal,Village,temple_name,name,designation,phone,email,createdDate " +
		"FROM managudi_users where Category = ? and Dist = ? and Mandal = ? and Village = ?";
		Object[] params = new Object[] {category, distName,mandalName,villageName };
		return this.getJdbcTemplate().query(sql,params, new ManagudiUsersRowMapper());
	}

	@Override
	public List<ManagudiUsers> searchManagudiUserById(String category,
			String distId, String mandalId, String villageId) {
		String distName = getDistName(Long.parseLong(distId));
		String mandalName = getMandalName(Long.parseLong(distId),Long.parseLong(mandalId));
		String villageName = getVillageName(Long.parseLong(distId),Long.parseLong(mandalId),Long.parseLong(villageId));
		String sql = "SELECT id, managudi_id,Dept,Category,association_name,State,Dist," +
				"Mandal,Village,temple_name,name,designation,phone,email,createdDate " +
				"FROM managudi_users where Category = ? and Dist = ? and Mandal = ? and Village = ?";
				Object[] params = new Object[] {category, distName,mandalName,villageName };
				return this.getJdbcTemplate().query(sql,params, new ManagudiUsersRowMapper());
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
