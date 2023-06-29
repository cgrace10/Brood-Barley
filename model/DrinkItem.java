package com.aca.broodnbarley.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DrinkItem {
	
	private Integer drinkId;
	private String drinkTitle;
	private Integer price;
	private String descriptions;
	private DrinkGenre genre;
	private double abv;
	private LocalDateTime updateDateTime;
	private LocalDateTime createDateTime;
	
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	public Integer getDrinkId() {
		return drinkId;
	}
	public void setDrinkId(Integer drinkId) {
		this.drinkId = drinkId;
	}
	public double getAbv() {
		return abv;
	}
	public void setAbv(double abv) {
		this.abv = abv;
	}
	public DrinkGenre getGenre() {
		return genre;
	}
	public void setGenre(DrinkGenre genre) {
		this.genre = genre;
	}
	public String getDrinkTitle() {
		return drinkTitle;
	}
	public void setDrinkTitle(String drinkTitle) {
		this.drinkTitle = drinkTitle;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

}
