package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Plot;

@Component
public class PlotSqlDAO implements PlotDAO {
	
	private JdbcTemplate template;
	
	
	public PlotSqlDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	

	@Override
	public Plot[] getPlotsByGardenId(Long id){
		List<Plot> plotList = new ArrayList<>();

		String sql = "SELECT * FROM plot WHERE garden_id = ? ";
		SqlRowSet results = template.queryForRowSet(sql, id);
		
		while (results.next()) {
			plotList.add(mapRowToPlot(results));
		}
		Plot[] plots = new Plot[plotList.size()];
		for(int i = 0; i < plotList.size(); i++) {
			plots[i] = plotList.get(i);
		}
		return plots;
	}
	
	
	@Override
	public Plot[] addNewPlotsForGarden(Plot[] plots) {
		Plot[] plotsReturned = new Plot[plots.length];
		
		Plot[] existingPlots = getPlotsByGardenId(plots[0].getGardenId());
		
		if (existingPlots.length > 0) {
		String sqlDelete = "DELETE FROM plot WHERE garden_id = ?";
		template.update(sqlDelete, plots[0].getGardenId());
		}
				
		String sql = "INSERT INTO plot (garden_id, plot_number, plant_id) VALUES (?, ?, ?) returning plot_id";
		int counter = 0;
		for (Plot p : plots) {
			Long plotId = template.queryForObject(sql, Long.class, p.getGardenId(), p.getPlotNumber(), p.getPlantId());
			p.setPlotId(plotId);
			plotsReturned[counter] = p;
			counter++;
		}
		return plotsReturned;
	}
	
	
	private Plot mapRowToPlot(SqlRowSet results) {
		Plot plot = new Plot();
		plot.setPlotId(results.getLong("plot_id"));
		plot.setGardenId(results.getLong("garden_id"));
		plot.setPlotNumber(results.getLong("plot_number"));
		plot.setPlantId(results.getLong("plant_id"));
		return plot;
		
	}




	

	

}
