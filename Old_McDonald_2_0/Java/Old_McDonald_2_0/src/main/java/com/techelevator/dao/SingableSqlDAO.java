package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Singable;

@Component
public class SingableSqlDAO implements SingableDAO {
	
	private JdbcTemplate template;
	
	public SingableSqlDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	@Override
	public List<Singable> getAllSingables(){
	String sql = "SELECT * FROM singable";
	SqlRowSet results = template.queryForRowSet(sql);
	List<Singable> retrievedSingables = new ArrayList<>();
	while (results.next()) {
		retrievedSingables.add(mapRowToSingable(results));
	}
	return retrievedSingables;
	}
	
	@Override
	public List<Singable> getSingablesByRegion(int regionId){
	String sql = "SELECT * FROM singable WHERE region = ?";
	SqlRowSet results = template.queryForRowSet(sql, regionId);
	List<Singable> retrievedSingables = new ArrayList<>();
	while (results.next()) {
		retrievedSingables.add(mapRowToSingable(results));
	}
	return retrievedSingables;
	}
	
	
	private Singable mapRowToSingable(SqlRowSet results) {
		Singable garden = new Singable();
		garden.setId(results.getInt("user_id"));
		garden.setName(results.getString("singable_name"));
		garden.setDescription(results.getString("description"));
		garden.setVehicle(results.getBoolean("is_vehicle"));
		garden.setSound(results.getString("sound"));
		garden.setRegion(results.getString("region"));
		return garden;
		
	}
}
