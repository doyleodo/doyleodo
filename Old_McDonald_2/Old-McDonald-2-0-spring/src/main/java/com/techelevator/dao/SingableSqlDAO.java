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
	
	@Override
	public Singable getRandomAnimalByRegion(String regionName){
	String sql = "SELECT * " + 
			"FROM singable s " + 
			"        JOIN region r ON s.region = r.region_id " + 
			"WHERE r.region_name = ? AND is_vehicle != true " + 
			"ORDER BY random() LIMIT 1;";
	SqlRowSet results = template.queryForRowSet(sql, regionName);
	results.next();
	Singable randomAnimal = mapRowToSingable(results);
	return randomAnimal;
	}	
	
	private Singable mapRowToSingable(SqlRowSet results) {
		Singable singable = new Singable();
		singable.setId(results.getInt("id"));
		singable.setName(results.getString("singable_name"));
		singable.setDescription(results.getString("description"));
		singable.setVehicle(results.getBoolean("is_vehicle"));
		singable.setSound(results.getString("sound"));
		singable.setRegion(results.getString("region"));
		return singable;
		
	}
}
