package com.aca.broodnbarley.model;

public enum DrinkGenre {
	Beer, Wine, SignatureCocktail, SeasonalCocktail, Mocktail;
	
	public static DrinkGenre convertStringToGenre(String value) {
		
		DrinkGenre myDrinkGenre = null;
		
		for(DrinkGenre drinkGenre : DrinkGenre.values()) {
			if(drinkGenre.toString().equalsIgnoreCase(value)) {
				myDrinkGenre = drinkGenre;
				break;
			}
		}
		
		return myDrinkGenre;
	}
	
}
