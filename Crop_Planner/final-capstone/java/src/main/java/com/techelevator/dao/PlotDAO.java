package com.techelevator.dao;

import com.techelevator.model.Plot;

public interface PlotDAO {
	
	Plot[] getPlotsByGardenId(Long id);
	Plot[] addNewPlotsForGarden(Plot[] plots);
	
}
