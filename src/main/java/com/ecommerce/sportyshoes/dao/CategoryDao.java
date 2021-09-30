package com.ecommerce.sportyshoes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.sportyshoes.entity.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {
	
	@Query("SELECT c FROM Category c WHERE c.categoryName = :categoryName")
	Category getCategoryByName(String categoryName);
}
