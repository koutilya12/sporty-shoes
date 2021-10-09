package com.ecommerce.sportyshoes.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.sportyshoes.constants.SportyShoesConstants;
import com.ecommerce.sportyshoes.dao.OrderDao;

import com.ecommerce.sportyshoes.dao.ProductStockDao;
import com.ecommerce.sportyshoes.entity.Order;
import com.ecommerce.sportyshoes.entity.OrderSearchCriteria;
import com.ecommerce.sportyshoes.entity.Response;
import com.ecommerce.sportyshoes.helpers.Validator;
import com.ecommerce.sportyshoes.service.OrderService;
import com.ecommerce.sportyshoes.service.ProductService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ProductStockDao productStockDao;
	
	@Autowired
	ProductService productService;

	@Transactional
	@Override
	public Response saveOrder(Order order) {
		order.setBookingTime(new Date());
		String errorMessage = Validator.validateSaveOrder(order);
		if(errorMessage != null) {
			return new Response(SportyShoesConstants.FAILED, errorMessage);
		}
	    for(int i = 0; i < order.getOrderDetails().size(); i++) {
	    	if(!productStockDao.existsById(order.getOrderDetails().get(i).getProductStock().getSkuId())) {
	    		return new Response(SportyShoesConstants.FAILED, "Product stock id not found");
	    	}
	    	if(order.getOrderDetails().get(i).getQuantity() >= productStockDao.getById(order.getOrderDetails().get(i).getProductStock().getSkuId()).getStock()) {
	    		return new Response(SportyShoesConstants.FAILED, "Insufficient product stock");
	    	}
		}	    
		orderDao.save(order);
		if(orderDao.existsById(order.getOrderId())) {
			for(int i = 0; i < order.getOrderDetails().size(); i++) {
				productService.updateProductStock(order.getOrderDetails().get(i).getProductStock().getSkuId(),(order.getTotQuantity() * (-1)));
			}
			return new Response(SportyShoesConstants.SUCCESS, "Order saved successfully");
		} else {
			return new Response(SportyShoesConstants.FAILED, "Save Order Failed");
		}
	}
	
	@Override
	public Response getOrder(OrderSearchCriteria orderSearchCriteria) {
		Integer userIdFlag;
		Integer categoryIdFlag;
		Integer dateFlag;
		String errorMessage = Validator.validateGetOrder(orderSearchCriteria);
		if(errorMessage != null) {
			return new Response(SportyShoesConstants.FAILED, errorMessage);
		}
		if(orderSearchCriteria.getUserId() == null) {
			userIdFlag = 0;  
		} else {
			userIdFlag = 1;
		}
		if(orderSearchCriteria.getCategoryId() == null) {
			categoryIdFlag = 0;  
		} else {
			categoryIdFlag = 1;
		}
		if(orderSearchCriteria.getFromDate() == null || orderSearchCriteria.getToDate() == null) {
			dateFlag = 0;
		} else {
			dateFlag = 1;
		}
		List<Order> orders = orderDao.getOrderList(orderSearchCriteria.getUserId(), userIdFlag, 
				orderSearchCriteria.getCategoryId(), categoryIdFlag, 
				orderSearchCriteria.getFromDate(), orderSearchCriteria.getToDate(), dateFlag);
		if(orders != null) {
		return new Response(SportyShoesConstants.SUCCESS, orders);
		} else {
			return new Response(SportyShoesConstants.FAILED, "order list not found");
		}
	}
}
