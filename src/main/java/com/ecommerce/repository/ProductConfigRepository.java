package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.ProductConfiguration;
import com.ecommerce.entity.embeddedid.ConfigurationId;

public interface ProductConfigRepository extends JpaRepository<ProductConfiguration, ConfigurationId>{

}
