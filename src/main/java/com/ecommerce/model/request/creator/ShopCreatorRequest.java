package com.ecommerce.model.request.creator;

import com.ecommerce.entity.Shop;

public class ShopCreatorRequest {
	
	private String name;

	public Shop convertModelToEntity() {
		Shop shop = new Shop();
		shop.setName(this.name);
		return shop;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
