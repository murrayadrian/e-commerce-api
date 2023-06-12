package com.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.response.list.IOrderItem;
import com.ecommerce.repository.OrderItemRepository;
import com.ecommerce.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Override
	public List<IOrderItem> getOrderItem(Long orderId) {
		return orderItemRepository.getOrderItem(orderId);
	}

}
