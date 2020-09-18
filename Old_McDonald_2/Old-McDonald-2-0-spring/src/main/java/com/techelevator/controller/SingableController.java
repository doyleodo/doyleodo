package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.SingableDAO;
import com.techelevator.model.Singable;

@RestController
@CrossOrigin
public class SingableController {
	@Autowired
	SingableDAO theSingables;
	
	@RequestMapping(path = { "/allSingables"}, method = RequestMethod.GET)
	public Singable[] listAllSingables() {
		List<Singable> allSingables= theSingables.getAllSingables();
		Singable[] singables = new Singable[allSingables.size()];
		singables = allSingables.toArray(singables);
		return singables;
	}
	
	@RequestMapping(path = { "/regionSingables"}, method = RequestMethod.GET)
	// example URL: http://localhost:8080/regionSingables?id=4
	public Singable[] listRegionSingables(@RequestParam int id) {
		List<Singable> regionSingables= theSingables.getSingablesByRegion(id);
		Singable[] singables = new Singable[regionSingables.size()];
		singables = regionSingables.toArray(singables);
		return singables;
	}
	
	@RequestMapping(path = {"/regionAnimal"}, method = RequestMethod.GET)
	// example URL: http://localhost:8080/regionAnimal?name=Ocean
	public Singable animalByRegionName(@RequestParam String name) {
		Singable searchByNameResult = theSingables.getRandomAnimalByRegion(name);
		return searchByNameResult;
	}
}
