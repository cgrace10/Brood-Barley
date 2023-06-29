package com.aca.broodnbarley.dao;

import java.util.List;

import com.aca.broodnbarley.model.DrinkGenre;
import com.aca.broodnbarley.model.DrinkItem;
import com.aca.broodnbarley.model.FoodGenre;
import com.aca.broodnbarley.model.FoodItem;

public interface BroodNBarleyDao {
	
	public List<FoodItem> getFoodItems();
	public List<FoodItem> getFoodItemsById(Integer foodId);
	public List<FoodItem> getFoodItemsByGenre(FoodGenre genre);
	public List<FoodItem> getFoodItemsByTitle(String foodTitle);
	public FoodItem createFoodItem(FoodItem newFoodItem);
	public FoodItem updateFoodItem(FoodItem updateFoodItem);
	public FoodItem deleteFoodItemsById(Integer foodId);
	
	public List<DrinkItem> getDrinkItems();
	public List<DrinkItem> getDrinkItemsById(Integer drinkId);
	public List<DrinkItem> getDrinkItemsByGenre(DrinkGenre genre);
	public List<DrinkItem> getDrinkItemsByTitle(String drinkTitle);
	public DrinkItem createDrinkItem(DrinkItem newDrinkItem);
	public DrinkItem updateDrinkItem(DrinkItem updateDrinkItem);
	public DrinkItem deleteDrinkItemsById(Integer drinkId);
	
	
	
	
}
