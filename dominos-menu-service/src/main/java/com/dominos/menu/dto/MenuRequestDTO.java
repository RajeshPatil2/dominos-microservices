package com.dominos.menu.dto;

import jakarta.validation.constraints.*;

public class MenuRequestDTO {

	@NotBlank
	private String itemName;

	@NotBlank
	private String category;

	@NotNull
	@Min(50)
	private Double price;

	@NotNull
	private Long restaurantId;

	private String offer;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}
}
