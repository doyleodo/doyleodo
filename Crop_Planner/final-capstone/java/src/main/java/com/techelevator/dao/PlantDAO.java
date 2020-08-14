package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.LineItem;
import com.techelevator.model.Plant;
import com.techelevator.model.Plot;

public interface PlantDAO {
	
	List<Plant> getAllPlants();
	List<Plant> getHZonePlants(String zoneName);
	Plant searchPlantByPlantName(String name);
	Plant addNewPlant(Plant plant);
	Plant editPlant(Plant plant);
	LineItem getPlantCostFromPlot(Plot plot);
	void removePlant(int id);
	
}
