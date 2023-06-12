package com.ecommerce.model.response.creator;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductItem;

public class ShowProductResponse {

	private Long id;
	
	private String name;
	
	private String image;
	
	private double price;
	
	public ShowProductResponse(ProductItem productItem, Product product) {
		this.id = productItem.getId();
		this.name = product.getName();
		this.image = productItem.getImage();
		this.price = productItem.getPrice();
	}
	

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}

	public double getPrice() {
		return price;
	}

}
