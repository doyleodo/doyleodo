package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Garden;

public interface GardenDAO {
	List<Garden>getAllGardens();
	Garden[] getGardensByUserId(Long id);
	Garden getGardenById(Long id);
	Garden searchGardenByName();
	Garden addNewGarden(Garden garden);

}
