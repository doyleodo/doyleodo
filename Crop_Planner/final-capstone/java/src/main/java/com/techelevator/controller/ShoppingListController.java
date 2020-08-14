package com.techelevator.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.PlantDAO;
import com.techelevator.dao.PlotDAO;
import com.techelevator.dao.SuppliesDAO;
import com.techelevator.model.LineItem;
import com.techelevator.model.Plot;
import com.techelevator.model.ShoppingList;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ShoppingListController {
	
	@Autowired
	SuppliesDAO theSupplies;
	@Autowired
	PlantDAO thePlants;
	@Autowired
	PlotDAO thePlots;
	
	@RequestMapping(path = { "/myShoppingList/{id}"}, method = RequestMethod.GET)
	public ShoppingList[] listAllItems(@PathVariable int id) {
		return theSupplies.getShoppingListsFromGardenId(id);
	}
	
	
	
	@RequestMapping(path = { "/addToMyShoppingList/{id}"}, method = RequestMethod.POST)
	public void addToList(@PathVariable Long id, @RequestBody ShoppingList list) {
			list.setGardenId(id);
			theSupplies.addToShoppingListGardenSupplies(list);
	}
	

	@RequestMapping(path = {"/generateSuggestedSeedlingList/{gardenid}"}, method = RequestMethod.GET)
	public LineItem[] suggestedList(@PathVariable Long gardenid) {
		List<LineItem> items = new ArrayList<>();
		Plot[] plots = thePlots.getPlotsByGardenId(gardenid);
		
		for(Plot p: plots) {
			items.add(thePlants.getPlantCostFromPlot(p));
		}
	
		Map <String, Integer> consolidated = new LinkedHashMap<>();
		Map <String, BigDecimal> consolidatedCost = new LinkedHashMap<>();
		for (LineItem n : items) {
			int count = consolidated.containsKey(n.getItemName()) ? consolidated.get(n.getItemName()) : 0;
			consolidated.put(n.getItemName(), count + 1);
			consolidatedCost.put(n.getItemName(), n.getCost());
		}

		
		LineItem[] seedling = new LineItem[consolidated.size()];
		for (int i = 0; i < consolidated.size(); i++) {
			LineItem temp = new LineItem();
			Object[] keys = consolidated.keySet().toArray();
			Object[] keysCost = consolidated.keySet().toArray();
			temp.setItemName(keys[i].toString());
			temp.setItemQuantity(consolidated.get(keys[i]) * thePlants.searchPlantByPlantName(keys[i].toString()).getPlantsPerSqFoot());
			temp.setCost(consolidatedCost.get(keysCost[i]).multiply(BigDecimal.valueOf(consolidated.get(keys[i]))));
			seedling[i] = temp;
		}
		return seedling;	
	}
	
	

}
