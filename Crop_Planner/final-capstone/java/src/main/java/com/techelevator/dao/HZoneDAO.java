package com.techelevator.dao;

import com.techelevator.model.HZone;
import com.techelevator.model.User;

public interface HZoneDAO {

	 void getHZoneByZip(User user, String hzone);
	 
	 HZone getHZoneDetails(String zoneName);

}
