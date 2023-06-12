package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.response.creator.CartDTO;
import com.ecommerce.model.response.creator.CartItemCreatorResponse;
import com.ecommerce.model.response.list.ICart;
import com.ecommerce.model.response.list.ICartItemList;

public interface CartService {

	public List<CartItemCreatorResponse> getAllItemInCart(Long cartId);
	
	public List<ICartItemList> findAllItemInCartDTO(Long cartId);
	
	public ICart getAllCartInfo(Long cartId);
	
	public CartDTO getEverything(Long cartId);
	
	public List<ICartItemList> findAllCheckedItemInCart(Long cartId);
}
