package com.ecommerce.sportyshoes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.sportyshoes.entity.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Long> {

	@Query("SELECT c FROM Cart c INNER  JOIN c.user u WHERE (u.userId = :userId)")
	List<Cart> getCart(Long userId);
}
