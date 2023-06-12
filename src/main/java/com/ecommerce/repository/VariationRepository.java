package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Variation;

public interface VariationRepository extends JpaRepository<Variation, Long>{

	public boolean existsByName(String name);
	
	public Variation findByName(String name);
}
