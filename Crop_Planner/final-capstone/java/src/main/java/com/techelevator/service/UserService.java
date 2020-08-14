package com.techelevator.service;

import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.HZone;
import com.techelevator.model.User;

public class UserService {

	private String BASE_URL = "https://phzmapi.org/";
	private RestTemplate restTemplate = new RestTemplate();
	
	
	public String getHardinessZone(User user) throws UserServiceException {
		
		HZone zone = null;
		try {
			zone = restTemplate.getForObject(BASE_URL + "/" + user.getZipcode() + ".json", HZone.class);	
		} catch (RestClientResponseException e) {
			throw new UserServiceException(e.getMessage());
		}
		return zone.getZone();
	}
	
}
