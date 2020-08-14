package com.techelevator.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.LineItem;
import com.techelevator.model.Plant;
import com.techelevator.model.Plot;


@Component
public class PlantSqlDAO implements PlantDAO {
	
	private JdbcTemplate template;

	public PlantSqlDAO(DataSource datasource) {
	    template = new JdbcTemplate(datasource);
	}

	@Override
	public List<Plant> getAllPlants() {
	    String sql = "SELECT * from plant";
	    SqlRowSet results = template.queryForRowSet(sql);
	    List<Plant> retrievedPlants = new ArrayList<>();
	    while (results.next()) {
	        retrievedPlants.add(mapRowToPlant(results));
	    }
	    return retrievedPlants;    
	}
	
	@Override
	public List<Plant> getHZonePlants(String zoneName) {
		String sql = "SELECT p.plant_id, p.plant_name, p.description, p.plants_per_sq_foot, "
				+ "p.sun_requirements, p.region, p.seedling_cost "
				+ "FROM plant p "
				+ "JOIN plant_hardiness ph ON p.plant_id=ph.plant_id "
				+ "JOIN hardiness h ON ph.zone_name=h.zone_name "
				+ "WHERE h.zone_name = ?";
		SqlRowSet results = template.queryForRowSet(sql, zoneName);
	    List<Plant> retrievedPlants = new ArrayList<>();
	    while (results.next()) {
	        retrievedPlants.add(mapRowToPlant(results));
	    }
	    return retrievedPlants;    
	}
	
	@Override
	public LineItem getPlantCostFromPlot(Plot plot) {
		LineItem list = new LineItem();
		String sql = "SELECT * FROM plant "
				+ "WHERE plant_id = ?";
		SqlRowSet results = template.queryForRowSet(sql, plot.getPlantId());
		if(results.next()) {
			BigDecimal costEach = results.getBigDecimal("seedling_cost");
			BigDecimal plants = results.getBigDecimal("plants_per_sq_foot");
			list.setCost(costEach.multiply(plants));
			list.setItemName(results.getString("plant_name"));
		}
		return list;
	}

	@Override
	public Plant searchPlantByPlantName(String name) {
		Plant plant = null;
		String sql = "SELECT * FROM plant WHERE plant_name = ?";
		SqlRowSet results = template.queryForRowSet(sql, name);
		if(results.next()) {
			plant = mapRowToPlant(results);
		}
		return plant;
	}
	@Override
	public Plant addNewPlant(Plant plant) {
		String sql = "INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES (?, ?, ?, ?, ?, ?) RETURNING plant_id";
		Long newPlantId = template.queryForObject(sql, Long.class, plant.getName(), plant.getDescription(), plant.getPlantsPerSqFoot(), plant.getSunRequirements(), plant.getRegion(), plant.getSeedlingCost());
		plant.setId(newPlantId);
		return plant;
	}
	
	@Override
	public Plant editPlant(Plant plant) {
		String sql = "UPDATE plant SET "
				+ "plant_name = ?, description = ?, plants_per_sq_foot = ?, "
				+ "sun_requirements = ?, region = ?, seedling_cost = ? "
				+ "WHERE plant_id = ?";
		template.update(sql, plant.getName(), plant.getDescription(), plant.getPlantsPerSqFoot(), plant.getSunRequirements(), plant.getRegion(), plant.getSeedlingCost(), plant.getId());
		return plant;
	}
	
	@Override
	public void removePlant(int id) {
		String sql = "DELETE FROM plant WHERE plant_id = ?";
		 template.update(sql, id);
		
	}
	private Plant mapRowToPlant(SqlRowSet results) {
		Plant plant = new Plant();
		plant.setId(results.getLong("plant_id"));
		plant.setDescription(results.getString("description"));
		plant.setName(results.getString("plant_name"));
		plant.setPlantsPerSqFoot(results.getInt("plants_per_sq_foot"));
		plant.setSunRequirements(results.getString("sun_requirements"));
		plant.setRegion(results.getString("region"));
		plant.setSeedlingCost(results.getBigDecimal("seedling_cost"));
		return plant;
	}

	

	


}
