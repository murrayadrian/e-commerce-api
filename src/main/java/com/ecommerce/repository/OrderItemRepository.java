package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.embeddedid.OrderItemId;
import com.ecommerce.model.response.list.IOrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId>{
	
	public OrderItem findOrderItemByIdOrderIdAndIdProductId(Long orderId, Long productId);
	
	@Query("select o from OrderItem o where o.order.id = ?1")
	public List<IOrderItem> getOrderItem(Long orderId);
}
