package com.ecommerce.sportyshoes.service;

import com.ecommerce.sportyshoes.entity.Order;
import com.ecommerce.sportyshoes.entity.OrderSearchCriteria;
import com.ecommerce.sportyshoes.entity.Response;

public interface OrderService {
	/**
	 * Saves new order
	 * @param order
	 * @return Success message if saved successfully else error message
	 */
	public Response saveOrder(Order order); 
	/**
	 * get previous orders
	 * @param orderSearchCriteria
	 * @return List of previously made orders if successful else error message
	 */
	public Response getOrder(OrderSearchCriteria orderSearchCriteria);
}
