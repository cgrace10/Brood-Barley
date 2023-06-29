package com.aca.broodnbarley.model;

public enum FoodGenre {
	Appetizer, Entree, Dessert;
	
	public static FoodGenre convertStringToGenre(String value) {
		
		FoodGenre myFoodGenre = null;
		
		for(FoodGenre foodGenre : FoodGenre.values()) {
			if(foodGenre.toString().equalsIgnoreCase(value)) {
				myFoodGenre = foodGenre;
				break;
			}
		}
		
		return myFoodGenre;
	}

}
