package com.aca.broodnbarley.service;

import java.util.List;

import com.aca.broodnbarley.dao.BroodNBarleyDao;
import com.aca.broodnbarley.dao.BroodNBarleyDaoImpl;
import com.aca.broodnbarley.dao.BroodNBarleyDaoMock;
import com.aca.broodnbarley.model.DrinkGenre;
import com.aca.broodnbarley.model.DrinkItem;
import com.aca.broodnbarley.model.FoodGenre;
import com.aca.broodnbarley.model.FoodItem;
import com.aca.broodnbarley.model.RequestError;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class BroodNBarleyService {
	
	private BroodNBarleyDao bNbDao = new BroodNBarleyDaoImpl();
	
	public List<FoodItem> getFoodItems() {
		return bNbDao.getFoodItems();
	}
	
	public List<FoodItem> getFoodItemsByGenre(FoodGenre genre){
		return bNbDao.getFoodItemsByGenre(genre);
	}

	public List<FoodItem> getFoodItemsByTitle(String foodTitle) {
		return bNbDao.getFoodItemsByTitle(foodTitle);
	}
	
	public List<DrinkItem> getDrinkItems() {
		return bNbDao.getDrinkItems();
	}

	public List<DrinkItem> getDrinkItemsByGenre(DrinkGenre genre) {
		return bNbDao.getDrinkItemsByGenre(genre);
	}

	public List<DrinkItem> getDrinkItemsByTitle(String drinkTitle) {
		return bNbDao.getDrinkItemsByTitle(drinkTitle);
	}

	public FoodItem createFoodItem(FoodItem newFoodItem) {
		validateFoodTitle(newFoodItem.getFoodTitle());
		return bNbDao.createFoodItem(newFoodItem);
	}

	public List<FoodItem> getFoodItemsById(Integer foodId) {
		validateFoodId(foodId);
		return bNbDao.getFoodItemsById(foodId);
	}

	public List<DrinkItem> getDrinkItemsById(Integer drinkId) {
		validateDrinkId(drinkId);
		return bNbDao.getDrinkItemsById(drinkId);
	}

	public DrinkItem createDrinkItem(DrinkItem newDrinkItem) {
		validateDrinkTitle(newDrinkItem.getDrinkTitle());
		return bNbDao.createDrinkItem(newDrinkItem);
	}
	
	public void validateFoodId(Integer foodId) {
		if(foodId <= 0) {
			RequestError error = new RequestError(1,
					"Invalid value for foodId '" + foodId + "'. Value must be > 0");
			Response response = Response.status(400)
					.entity(error)
					.build();
			throw new WebApplicationException(response);
		}
	}
	
	public void validateDrinkId(Integer drinkId) {
		if(drinkId <= 0) {
			RequestError error = new RequestError(2,
					"Invalid Value for drinkId '" + drinkId + "'. Value must be > 0");
			Response response = Response.status(400)
					.entity(error)
					.build();
			throw new WebApplicationException(response);
							
		}
	}
	
	public void validateFoodTitle(String foodTitle) {
		if(null == foodTitle || foodTitle.length() < 1) {
			RequestError error = new RequestError(3,
					"Invalid value for foodTitle '" + foodTitle + "'. Value must be 1 or more characters");
			Response response = Response.status(400)
					.entity(error)
					.build();
			throw new WebApplicationException(response);
		}
	}
	
	public void validateDrinkTitle(String drinkTitle) {
		if(null == drinkTitle || drinkTitle.length() < 1) {
			RequestError error = new RequestError(4,
					"Invalid value for drinkTitle '" + drinkTitle + "'. Value must be 1 or more characters");
			Response response = Response.status(400)
					.entity(error)
					.build();
			throw new WebApplicationException(response);
		}
	}

	public FoodItem updateFoodItem(FoodItem updateFoodItem) {
		validateFoodId(updateFoodItem.getFoodId());
		validateFoodTitle(updateFoodItem.getFoodTitle());
		
		List<FoodItem> myFoodMenu = bNbDao.getFoodItemsById(updateFoodItem.getFoodId());
		if(myFoodMenu.size() == 1) {
			return bNbDao.updateFoodItem(updateFoodItem);
		}else {
			RequestError error = new RequestError(5,
					"Food Id '" + updateFoodItem.getFoodId() + "' does not exist.");
			Response response = Response.status(400)
					.entity(error)
					.build();
			throw new WebApplicationException(response);
		}
	}

	public DrinkItem updateDrinkItem(DrinkItem updateDrinkItem) {
		validateDrinkId(updateDrinkItem.getDrinkId());
		validateDrinkTitle(updateDrinkItem.getDrinkTitle());
		
		List<DrinkItem> myDrinkMenu = bNbDao.getDrinkItemsById(updateDrinkItem.getDrinkId());
		if(myDrinkMenu.size() == 1) {
			return bNbDao.updateDrinkItem(updateDrinkItem);
		}else {
			RequestError error = new RequestError(6,
					"Drink Id '" + updateDrinkItem.getDrinkId() + "' does not exist.");
			Response response = Response.status(400)
					.entity(error)
					.build();
			throw new WebApplicationException(response);
		}
	}

	public FoodItem deleteFoodItemsById(Integer foodId) {
		validateFoodId(foodId);
		return bNbDao.deleteFoodItemsById(foodId);
	}

	public DrinkItem deleteDrinkItemsById(Integer drinkId) {
		validateDrinkId(drinkId);
		return bNbDao.deleteDrinkItemsById(drinkId);
	}

}
