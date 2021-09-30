package com.ecommerce.sportyshoes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.sportyshoes.entity.ProductStock;

@Repository
public interface ProductStockDao extends JpaRepository<ProductStock, Long> {
	
	@Modifying
	@Query("UPDATE ProductStock s SET s.stock = (s.stock + (:updateQuantity))  WHERE s.skuId = :skuId")
	int updateStock(Long skuId, Integer updateQuantity);
}
