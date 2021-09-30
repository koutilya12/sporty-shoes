package com.ecommerce.sportyshoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.sportyshoes.entity.Order;
import com.ecommerce.sportyshoes.entity.OrderSearchCriteria;
import com.ecommerce.sportyshoes.entity.Response;
import com.ecommerce.sportyshoes.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@PutMapping("/saveOrder") 
	public @ResponseBody Response saveOrder(@RequestBody Order order) {
		return orderService.saveOrder(order);
	}
	
	@GetMapping("/getOrder")
	public @ResponseBody Response getOrder(@RequestBody OrderSearchCriteria orderSearchCriteria) {
		return orderService.getOrder(orderSearchCriteria);
	}
}
