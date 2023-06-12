package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long>{
	
	public ProductItem findTop1ByProductOrderByPrice(Product product);
}
