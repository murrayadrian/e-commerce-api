package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.VariationValue;

public interface VariationValueRepository extends JpaRepository<VariationValue, Long>{

	public VariationValue findByValue(String value);
}
