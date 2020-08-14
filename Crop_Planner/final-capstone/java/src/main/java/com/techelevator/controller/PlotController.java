package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.PlotDAO;
import com.techelevator.model.Plot;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PlotController {

	@Autowired
	PlotDAO plotDao;
	

	@RequestMapping(path = { "/garden/{id}/plots"}, method = RequestMethod.GET)
	public Plot[] getPlotsByGardenId(@PathVariable Long id) {
		Plot[] plots = plotDao.getPlotsByGardenId(id);
		return plots;
	}
	
	
	@RequestMapping(path = { "/garden/{id}/plots"}, method = RequestMethod.POST)
	public Plot[] saveGardenPlots(@PathVariable Long id, @RequestBody Plot[] plots) {
		Plot[] results = plotDao.addNewPlotsForGarden(plots);
		return results;
	}
	
	
	
	
	
	
	
}
