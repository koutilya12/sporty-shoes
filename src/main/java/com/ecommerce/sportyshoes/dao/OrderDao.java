package com.ecommerce.sportyshoes.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.sportyshoes.entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Long> {
	@Query(value = "SELECT * FROM orders o inner join user u on o.userId = u.userId\r\n"
			+ "inner join order_details od on o.orderId = od.orderId inner join product_stock ps on  od.skuId = ps.skuId \r\n"
			+ "inner join product p on ps.productId = p.productId inner join category c on p.categoryID = c.categoryId \r\n"
			+ "where (0 =:userIdFlag or u.userId =:userId) and (0 =:categoryIdFlag or c.categoryId =:categoryId) and (0 =:dateFlag or (o.bookingTime between :fromDate and :toDate))", nativeQuery = true)
	List<Order> getOrderList(Long userId, Integer userIdFlag, Long categoryId, Integer categoryIdFlag, Date fromDate,
			Date toDate, Integer dateFlag);
}

