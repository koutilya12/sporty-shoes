package com.ecommerce.sportyshoes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.sportyshoes.entity.Brand;

@Repository
public interface BrandDao extends JpaRepository<Brand, Long> {
	
	@Query("SELECT b FROM Brand b WHERE b.brandName = :brandName")
	Brand getBrandByName(String brandName);
}
