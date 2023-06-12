package com.ecommerce.service;

import com.ecommerce.model.request.creator.CartItemCreatorRequest;
import com.ecommerce.model.request.creator.CartItemInfoRequest;
import com.ecommerce.model.request.creator.CheckItemRequest;
import com.ecommerce.model.request.creator.RemoveProductRequest;
import com.ecommerce.model.request.creator.ShopCheckRequest;
import com.ecommerce.model.response.creator.CartItemCreatorResponse;
import com.ecommerce.model.response.creator.ChangeQuantityResponse;
import com.ecommerce.model.response.creator.FinalPriceResponse;

public interface CartItemService {

	public CartItemCreatorResponse addProductToCart(CartItemCreatorRequest cartItemCreatorRequest);

	public FinalPriceResponse removeProductFromCart(RemoveProductRequest removeProductRequest);
	
	//
	public FinalPriceResponse checkItem(CheckItemRequest info);

	public FinalPriceResponse checkAllItemInShop(ShopCheckRequest info);
	
	//
	public ChangeQuantityResponse changeQuantity(CartItemInfoRequest info);
	
	//
	public FinalPriceResponse checkAllItem(Long cartId);

	public void removeAllCheckedItem(Long cartId);
}
