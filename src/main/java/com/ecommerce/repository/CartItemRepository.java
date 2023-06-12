package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.entity.CartItem;
import com.ecommerce.entity.embeddedid.CartItemId;
import com.ecommerce.model.response.list.ICartItemList;

public interface CartItemRepository extends JpaRepository<CartItem, CartItemId> {
	
	@Query("select c from CartItem c where c.id.cartId = ?1")
	public List<CartItem> findAllItemInCart(Long cartId);
	
	@Query("select c from CartItem c where c.id.cartId = ?1")
	public List<ICartItemList> findAllItemInCartDTO(Long cartId);
	
	public CartItem findByIdProductItemIdAndIdCartId(Long productItemId, Long cartId);
	
	@Query("select c from CartItem c where c.id.cartId = ?1 and c.isCheck = 1")
	public List<CartItem> findAllCheckedItemInCart(Long cartId);
	
	@Query("select c from CartItem c where c.id.cartId = ?1 and c.isCheck = 1")
	public List<ICartItemList> findAllCheckedItemInCartDTO(Long cartId);
	
	@Modifying
	public void deleteByIdProductItemIdAndIdCartId(Long productItemId, Long cartId);
	
	@Query("select c from CartItem c where c.id.productItemId = ?1")
	public ICartItemList findByProductItemId(Long productItemId);
	
	@Modifying
	@Query("delete from CartItem c where c.id.cartId = ?1 and c.isCheck = 1")
	public void deleteAllCheckedItem(Long cartId);
}
