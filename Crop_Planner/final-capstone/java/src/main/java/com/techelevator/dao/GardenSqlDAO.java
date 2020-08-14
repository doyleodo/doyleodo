package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Garden;

@Component
public class GardenSqlDAO implements GardenDAO {
	
	private JdbcTemplate template;
	
	
	public GardenSqlDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<Garden> getAllGardens(){
		String sql = "SELECT * FROM garden";
		SqlRowSet results = template.queryForRowSet(sql);
		List<Garden> retrievedGardens = new ArrayList<>();
		while (results.next()) {
			retrievedGardens.add(mapRowToGarden(results));
		}
		return retrievedGardens;
	}
	
	@Override
	public Garden[] getGardensByUserId(Long id){
		List<Garden> retrievedGardens = new ArrayList<>();
		
		String sql = "SELECT * FROM garden WHERE user_id = ? ";
		SqlRowSet results = template.queryForRowSet(sql, id);

		while (results.next()) {
			retrievedGardens.add(mapRowToGarden(results));
		}
		Garden[] gardens = new Garden[retrievedGardens.size()];
		for (int i = 0; i < gardens.length; i++) {
			gardens[i] = retrievedGardens.get(i);
		}
		return gardens;
	}
	
	@Override
	public Garden getGardenById(Long id){
		
		String sql = "SELECT * FROM garden WHERE garden_id = ? ";
		SqlRowSet results = template.queryForRowSet(sql, id);

		results.next();
		Garden garden = mapRowToGarden(results);
		return garden;
	}
	
	@Override
	public Garden searchGardenByName() {
		Garden garden = null;
		String sql = "SELECT * FROM garden WHERE garden_name = ?";
		SqlRowSet results = template.queryForRowSet(sql);
		if(results.next()) {
			garden = mapRowToGarden(results);
		}
		return garden;
	}
	@Override
	public Garden addNewGarden(Garden garden) {
		String sql = "INSERT INTO garden (user_id, length, width, garden_name) VALUES (?, ?, ?, ?) returning garden_id";
		Long newGardenId = template.queryForObject(sql, Long.class, garden.getUserId(), garden.getGardenLength(), garden.getGardenWidth(), garden.getGardenName());
		garden.setGardenId(newGardenId);
		return garden;
	}
	
	
	
	private Garden mapRowToGarden(SqlRowSet results) {
		Garden garden = new Garden();
		garden.setUserId(results.getLong("user_id"));
		garden.setGardenId(results.getLong("garden_id"));
		garden.setGardenLength(results.getLong("length"));
		garden.setGardenWidth(results.getLong("width"));
		garden.setGardenName(results.getString("garden_name"));
		return garden;
		
	}

	

	

}
