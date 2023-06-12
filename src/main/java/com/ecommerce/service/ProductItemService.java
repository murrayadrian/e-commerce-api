package com.ecommerce.service;

import com.ecommerce.model.request.creator.AddProductRequest;
import com.ecommerce.model.response.creator.AddProductResponse;

public interface ProductItemService {
	
	public AddProductResponse addProduct(AddProductRequest addProductRequest);
}
