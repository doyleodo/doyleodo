package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.LineItem;
import com.techelevator.model.ShoppingList;
import com.techelevator.model.Supplies;

public interface SuppliesDAO {
	
	List<Supplies> getAllSupplies();
	Supplies searchSupplyBySupplyName(String name);
	ShoppingList[] getShoppingListsFromGardenId(int gardenId);
	public void addToShoppingListGardenSupplies(ShoppingList item);
	
	

}
