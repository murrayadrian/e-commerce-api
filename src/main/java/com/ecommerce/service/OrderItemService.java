package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.response.list.IOrderItem;

public interface OrderItemService {
	
	public List<IOrderItem> getOrderItem(Long orderId);
}
