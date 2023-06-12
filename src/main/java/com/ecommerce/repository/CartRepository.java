package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.entity.Cart;
import com.ecommerce.model.response.list.ICart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	
	@Query("select c from Cart c where c.user.id = ?1")
	public Cart findByUserId(Long id);
	
	@Query("select c from Cart c where c.id = ?1")
	public ICart getAllCartInfo(Long cartId);
}
