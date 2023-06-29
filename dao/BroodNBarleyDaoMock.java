package com.aca.broodnbarley.dao;

import java.util.ArrayList;
import java.util.List;

import com.aca.broodnbarley.model.DrinkGenre;
import com.aca.broodnbarley.model.DrinkItem;
import com.aca.broodnbarley.model.FoodGenre;
import com.aca.broodnbarley.model.FoodItem;

public class BroodNBarleyDaoMock implements BroodNBarleyDao {
	
	private static Integer LastFoodId = 0;
	
	private static Integer getNextFoodId() {
		LastFoodId++;
		return LastFoodId;
	}
	
	private static Integer LastDrinkId = 0;
	
	private static Integer getNextDrinkId() {
		LastDrinkId++;
		return LastDrinkId;
	}
	
	private static List<DrinkItem> drinkMenu = new ArrayList<DrinkItem>();
	
	static {
		DrinkItem oldFashioned = new DrinkItem();
		oldFashioned.setDrinkTitle("Brood Old Fashioned");
		oldFashioned.setPrice(8);
		oldFashioned.addDescriptions("old grandad bonded bourbon");
		oldFashioned.addDescriptions("raw sugar");
		oldFashioned.addDescriptions("water");
		oldFashioned.addDescriptions("proprietary blend of bitters");
		oldFashioned.setGenre(DrinkGenre.SignatureCocktail);
		oldFashioned.setDrinkId(getNextDrinkId());
		
		DrinkItem poloma = new DrinkItem();
		poloma.setDrinkTitle("B & B Poloma");
		poloma.setPrice(9);
		poloma.addDescriptions("tequila");
		poloma.addDescriptions("grapefruit cordial");
		poloma.addDescriptions("fresh lime");
		poloma.addDescriptions("grapefruit soda");
		poloma.setGenre(DrinkGenre.SignatureCocktail);
		poloma.setDrinkId(getNextDrinkId());
		
		DrinkItem derby = new DrinkItem();
		derby.setDrinkTitle("Derby Renewal");
		derby.setPrice(13);
		derby.addDescriptions("rittenhouse rye");
		derby.addDescriptions("cynar");
		derby.addDescriptions("grapefruit codrial");
		derby.addDescriptions("italicus");
		derby.addDescriptions("peychauds apertivo");
		derby.setGenre(DrinkGenre.SeasonalCocktail);
		derby.setDrinkId(getNextDrinkId());
		
		DrinkItem lavender = new DrinkItem();
		lavender.setDrinkTitle("Lavender Fields");
		lavender.setPrice(10);
		lavender.addDescriptions("lavender infused vodka");
		lavender.addDescriptions("fresh lemon");
		lavender.addDescriptions("creme de violette");
		lavender.addDescriptions("sugar");
		lavender.setGenre(DrinkGenre.SeasonalCocktail);
		lavender.setDrinkId(getNextDrinkId());
		
		DrinkItem oberon = new DrinkItem();
		oberon.setDrinkTitle("Bell's Oberon Ale");
		oberon.setPrice(7);
		oberon.setAbv(5.8);
		oberon.setGenre(DrinkGenre.Beer);
		oberon.setDrinkId(getNextDrinkId());
		
		DrinkItem peachCider = new DrinkItem();
		peachCider.setDrinkTitle("Black Apple Peach Cider");
		peachCider.setPrice(8);
		peachCider.setAbv(6.9);
		peachCider.setGenre(DrinkGenre.Beer);
		peachCider.setDrinkId(getNextDrinkId());
		
		
		drinkMenu.add(oldFashioned);
		drinkMenu.add(poloma);
		drinkMenu.add(derby);
		drinkMenu.add(lavender);
		drinkMenu.add(oberon);
		drinkMenu.add(peachCider);
	}
	
	private static List<FoodItem> foodMenu = new ArrayList<FoodItem>();
	
	static {
		FoodItem legitCheesesteak = new FoodItem();
		legitCheesesteak.setFoodTitle("Legit Cheesesteak");
		legitCheesesteak.setPrice(19);
		legitCheesesteak.addDescription("shaved ribeye");
		legitCheesesteak.addDescription("pilsner onions");
		legitCheesesteak.addDescription("cheese sauce");
		legitCheesesteak.addDescription("toasted roll");
		legitCheesesteak.setGenre(FoodGenre.Entree);
		legitCheesesteak.setFoodId(getNextFoodId());
		
		FoodItem chickenSammie = new FoodItem();
		chickenSammie.setFoodTitle("Chicken Sammie");
		chickenSammie.setPrice(15);
		chickenSammie.addDescription("fried chicken breast");
		chickenSammie.addDescription("lettuce");
		chickenSammie.addDescription("tomato");
		chickenSammie.addDescription("pickle relish");
		chickenSammie.addDescription("shush sauce");
		chickenSammie.addDescription("asiago brioche");
		chickenSammie.setGenre(FoodGenre.Entree);
		chickenSammie.setFoodId(getNextFoodId());
		
		FoodItem omgShrimp = new FoodItem();
		omgShrimp.setFoodTitle("OMG! Shrimp");
		omgShrimp.setPrice(16);
		omgShrimp.addDescription("fried shrimp");
		omgShrimp.addDescription("sweet and spicy smoked pineapple");
		omgShrimp.addDescription("mixed greens");
		omgShrimp.addDescription("green onions");
		omgShrimp.setGenre(FoodGenre.Appetizer);
		omgShrimp.setFoodId(getNextFoodId());
		
		FoodItem tributeWings = new FoodItem();
		tributeWings.setFoodTitle("Tribute Wings");
		tributeWings.setPrice(15);
		tributeWings.addDescription("fried duck wing drumlettes");
		tributeWings.addDescription("AR honey chili sauce");
		tributeWings.addDescription("ranch drizzle");
		tributeWings.setGenre(FoodGenre.Appetizer);
		tributeWings.setFoodId(getNextFoodId());
		
		FoodItem brownieCheesecake = new FoodItem();
		brownieCheesecake.setFoodTitle("Brownie Cheesecake");
		brownieCheesecake.setPrice(8);
		brownieCheesecake.addDescription("chocalate crust");
		brownieCheesecake.addDescription("brownie chunks");
		brownieCheesecake.addDescription("caramel drizzle");
		brownieCheesecake.setGenre(FoodGenre.Dessert);
		brownieCheesecake.setFoodId(getNextFoodId());
		
		FoodItem iceCream = new FoodItem();
		iceCream.setFoodTitle("Coconut Ice Cream");
		iceCream.setPrice(6);
		iceCream.addDescription("coconut folded ice cream");
		iceCream.addDescription("chocolate sauce");
		iceCream.addDescription("toasted almonds on top");
		iceCream.setGenre(FoodGenre.Dessert);
		iceCream.setFoodId(getNextFoodId());
		
		
		foodMenu.add(legitCheesesteak);
		foodMenu.add(chickenSammie);
		foodMenu.add(omgShrimp);
		foodMenu.add(tributeWings);
		foodMenu.add(brownieCheesecake);
		foodMenu.add(iceCream);
		
		
	}

	@Override
	public List<FoodItem> getFoodItems() {
		
		List<FoodItem> myFoodMenu = new ArrayList<FoodItem>();
		myFoodMenu.addAll(foodMenu);
		return myFoodMenu;
	}

	@Override
	public List<FoodItem> getFoodItemsByGenre(FoodGenre genre) {
		List<FoodItem> myFoodMenu = new ArrayList<FoodItem>();
		
		for (FoodItem foodItem : BroodNBarleyDaoMock.foodMenu) {
			if(foodItem.getGenre().equals(genre)) {
				myFoodMenu.add(foodItem);
			}
		}
		
		return myFoodMenu;
	}

	@Override
	public List<FoodItem> getFoodItemsByTitle(String foodTitle) {
		List<FoodItem> myFoodMenu = new ArrayList<FoodItem>();
		
		for (FoodItem foodItem : BroodNBarleyDaoMock.foodMenu) {
			if(foodItem.getFoodTitle().toLowerCase().contains(foodTitle.toLowerCase())) {
				myFoodMenu.add(foodItem);
			}
		}
		return myFoodMenu;
	}

	@Override
	public List<DrinkItem> getDrinkItems() {
		List<DrinkItem> myDrinkMenu = new ArrayList<DrinkItem>();
		myDrinkMenu.addAll(drinkMenu);
		return myDrinkMenu;
	}

	@Override
	public List<DrinkItem> getDrinkItemsByGenre(DrinkGenre genre) {
		List<DrinkItem> myDrinkMenu = new ArrayList<DrinkItem>();
		
		for (DrinkItem drinkItem : BroodNBarleyDaoMock.drinkMenu) {
			if(drinkItem.getGenre().equals(genre)) {
				myDrinkMenu.add(drinkItem);
			}
		}
		return myDrinkMenu;
	}

	@Override
	public List<DrinkItem> getDrinkItemsByTitle(String drinkTitle) {
		List<DrinkItem> myDrinkMenu = new ArrayList<DrinkItem>();
		
		for (DrinkItem drinkItem : BroodNBarleyDaoMock.drinkMenu) {
			if(drinkItem.getDrinkTitle().toLowerCase().contains(drinkTitle.toLowerCase())) {
				myDrinkMenu.add(drinkItem);
			}
		}
		return myDrinkMenu;
	}

	@Override
	public FoodItem createFoodItem(FoodItem newFoodItem) {
		newFoodItem.setFoodId(getNextFoodId());
		BroodNBarleyDaoMock.foodMenu.add(newFoodItem);
		return newFoodItem;
	}

	@Override
	public List<FoodItem> getFoodItemsById(Integer foodId) {
		List<FoodItem> myFoodMenu = new ArrayList<FoodItem>();
		
		for(FoodItem foodItem : BroodNBarleyDaoMock.foodMenu) {
			if(foodItem.getFoodId().intValue() == foodId.intValue()) {
				myFoodMenu.add(foodItem);
			}
		}
		return myFoodMenu;
	}

	@Override
	public List<DrinkItem> getDrinkItemsById(Integer drinkId) {
		List<DrinkItem> myDrinkMenu = new ArrayList<DrinkItem>();
		
		for(DrinkItem drinkItem : BroodNBarleyDaoMock.drinkMenu) {
			if(drinkItem.getDrinkId().intValue() == drinkId.intValue()) {
				myDrinkMenu.add(drinkItem);
			}
		}
		return myDrinkMenu;
	}

	@Override
	public DrinkItem createDrinkItem(DrinkItem newDrinkItem) {
		newDrinkItem.setDrinkId(getNextDrinkId());
		BroodNBarleyDaoMock.drinkMenu.add(newDrinkItem);
		return newDrinkItem;
	}

	@Override
	public FoodItem updateFoodItem(FoodItem updateFoodItem) {
		
		for(FoodItem foodItem : BroodNBarleyDaoMock.foodMenu) {
			if(foodItem.getFoodId().intValue() == updateFoodItem.getFoodId().intValue()) {
				foodItem.setGenre(updateFoodItem.getGenre());
				foodItem.setFoodTitle(updateFoodItem.getFoodTitle());
				foodItem.setDescriptions(updateFoodItem.getDescriptions());
				foodItem.setPrice(updateFoodItem.getPrice());
				break;
			}
		}
		return updateFoodItem;
	}

	@Override
	public DrinkItem updateDrinkItem(DrinkItem updateDrinkItem) {
		for(DrinkItem drinkItem : BroodNBarleyDaoMock.drinkMenu) {
			if(drinkItem.getDrinkId().intValue() == updateDrinkItem.getDrinkId().intValue()) {
				drinkItem.setGenre(updateDrinkItem.getGenre());
				drinkItem.setDrinkTitle(updateDrinkItem.getDrinkTitle());
				drinkItem.setDescriptions(updateDrinkItem.getDescriptions());
				drinkItem.setPrice(updateDrinkItem.getPrice());
				drinkItem.setAbv(updateDrinkItem.getAbv());
				break;
			}
		}
		return updateDrinkItem;
	}

	@Override
	public FoodItem deleteFoodItemsById(Integer foodId) {
		List<FoodItem> myFoodMenu = getFoodItemsById(foodId);
		FoodItem foodItem = null;
		
		if(myFoodMenu.size() == 1) {
			foodItem = myFoodMenu.get(0);
			BroodNBarleyDaoMock.foodMenu.remove(foodItem);
		}
		return foodItem;
	}

	@Override
	public DrinkItem deleteDrinkItemsById(Integer drinkId) {
		List<DrinkItem> myDrinkMenu = getDrinkItemsById(drinkId);
		DrinkItem drinkItem = null;
		
		if(myDrinkMenu.size() == 1) {
			drinkItem = myDrinkMenu.get(0);
			BroodNBarleyDaoMock.drinkMenu.remove(drinkItem);
		}
		return drinkItem;
	}

}
