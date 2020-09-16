package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Singable;

public interface SingableDAO {

	List<Singable> getAllSingables();
	List<Singable> getSingablesByRegion(int regionId);

}
