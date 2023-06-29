package com.aca.broodnbarley.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FoodItem {
	
	private Integer foodId;
	private String foodTitle;
	private FoodGenre genre;
	private Integer price;
	private String descriptions;
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
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public String getFoodTitle() {
		return foodTitle;
	}
	public void setFoodTitle(String foodTitle) {
		this.foodTitle = foodTitle;
	}
	public FoodGenre getGenre() {
		return genre;
	}
	public void setGenre(FoodGenre genre) {
		this.genre = genre;
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
