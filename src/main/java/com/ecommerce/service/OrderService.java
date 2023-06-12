package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.request.creator.OrderRequest;
import com.ecommerce.model.response.list.IOrderItem;

public interface OrderService {
	
	public List<IOrderItem> order(OrderRequest orderRequest);
	
}
