package com.ecommerce.sportyshoes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.sportyshoes.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long>{
	
//	@Query("SELECT p FROM Product p WHERE p.productId = :productId OR p.productName =  :")
//	List<Product> getProducts(Product product);
}
