package com.aca.broodnbarley.controller;

import java.util.List;

import com.aca.broodnbarley.model.DrinkGenre;
import com.aca.broodnbarley.model.DrinkItem;
import com.aca.broodnbarley.model.FoodGenre;
import com.aca.broodnbarley.model.FoodItem;
import com.aca.broodnbarley.service.BroodNBarleyService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/menu") 
@Produces(MediaType.APPLICATION_JSON)
public class BroodNBarleyController {
	
	private BroodNBarleyService bNbService = new BroodNBarleyService();
	
	@GET
	@Path("/foodmenu")
	public List<FoodItem> getFoodItems() {
		return bNbService.getFoodItems();
	}
	@GET
	@Path("/foodmenu/{foodIdValue}")
	public List<FoodItem> getFoodItemsById(@PathParam("foodIdValue") Integer foodId) {
		return bNbService.getFoodItemsById(foodId);
	}
	
	@GET
	@Path("/foodmenu/genre/{genreValue}")
	public List<FoodItem> getFoodItemsByGenre(@PathParam("genreValue") FoodGenre genre) {
		return bNbService.getFoodItemsByGenre(genre);
	}
	
	@GET
	@Path("/foodmenu/title/{titleValue}")
	public List<FoodItem> getFoodItemsByTitle(@PathParam("titleValue") String foodTitle){
		return bNbService.getFoodItemsByTitle(foodTitle);
	}
	
	@GET
	@Path("/drinkmenu")
	public List<DrinkItem> getDrinkItems() {
		return bNbService.getDrinkItems();
	}
	
	@GET
	@Path("/drinkmenu/{drinkIdValue}")
	public List<DrinkItem> getDrinkItemsById(@PathParam("drinkIdValue") Integer drinkId) {
		return bNbService.getDrinkItemsById(drinkId);
	}
	
	@GET
	@Path("/drinkmenu/genre/{genreValue}")
	public List<DrinkItem> getDrinkItemsByGenre(@PathParam("genreValue") DrinkGenre genre) {
		return bNbService.getDrinkItemsByGenre(genre);
	}
	
	@GET
	@Path("/drinkmenu/title/{titleValue}")
	public List<DrinkItem> getDrinkItemsByGenre(@PathParam("titleValue") String drinkTitle) {
		return bNbService.getDrinkItemsByTitle(drinkTitle);
	}
	
	@POST
	@Path("/foodmenu")
	@Consumes(MediaType.APPLICATION_JSON)
	public FoodItem createFoodItem(FoodItem newFoodItem) {
		return bNbService.createFoodItem(newFoodItem);
	}
	
	@POST
	@Path("/drinkmenu")
	@Consumes(MediaType.APPLICATION_JSON)
	public DrinkItem createDrinkItem(DrinkItem newDrinkItem) {
		return bNbService.createDrinkItem(newDrinkItem);
	}
	
	@PUT
	@Path("/foodmenu")
	@Consumes(MediaType.APPLICATION_JSON)
	public FoodItem updateFoodItem(FoodItem updateFoodItem) {
		return bNbService.updateFoodItem(updateFoodItem);
	}
	
	@PUT
	@Path("/drinkmenu")
	@Consumes(MediaType.APPLICATION_JSON)
	public DrinkItem updateDrinkItem(DrinkItem updateDrinkItem) {
		return bNbService.updateDrinkItem(updateDrinkItem);
	}
	
	@DELETE
	@Path("/foodmenu/{foodIdValue}")
	public FoodItem deleteFoodItemsById(@PathParam("foodIdValue") Integer foodId) {
		return bNbService.deleteFoodItemsById(foodId);
	}
	
	@DELETE
	@Path("/drinkmenu/{drinkIdValue}")
	public DrinkItem deleteDrinkItemsById(@PathParam("drinkIdValue") Integer drinkId) {
		return bNbService.deleteDrinkItemsById(drinkId);
	}

}
