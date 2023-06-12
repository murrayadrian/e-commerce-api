package com.ecommerce.model.request.creator;

import com.ecommerce.entity.Cart;
import com.ecommerce.entity.CartItem;
import com.ecommerce.entity.ProductItem;

public class CartItemCreatorRequest {

	private Long cartId;
	
	private Long productItemId;

	private int orderQuantity;

	
	
	public CartItem convertToEntity(ProductItem productItem, Cart cart) {
		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setProductItem(productItem);
		cartItem.setQuantity(orderQuantity);
		cartItem.setTotalPrice(orderQuantity * productItem.getPrice());
		cartItem.setCheck(false);
		return cartItem;
	}
	
	public CartItem updateExistedCartItem(CartItem cartItem, int orderQuantity) {
		int updateQuantity = cartItem.getQuantity() + orderQuantity;
		cartItem.setQuantity(updateQuantity);
		cartItem.setTotalPrice(updateQuantity * cartItem.getProductItem().getPrice());
		return cartItem;
	}
	
	public Long getProductItemId() {
		return productItemId;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}
	
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity =  orderQuantity;
	}

	public Long getCartId() {
		return cartId;
	}
	
	
	
}
