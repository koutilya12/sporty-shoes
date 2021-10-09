package com.ecommerce.sportyshoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.sportyshoes.constants.OrderStatus;
import com.ecommerce.sportyshoes.constants.SportyShoesConstants;
import com.ecommerce.sportyshoes.entity.Category;
import com.ecommerce.sportyshoes.entity.Order;
import com.ecommerce.sportyshoes.entity.OrderDetails;
import com.ecommerce.sportyshoes.entity.OrderSearchCriteria;
import com.ecommerce.sportyshoes.entity.ProductStock;
import com.ecommerce.sportyshoes.entity.Response;
import com.ecommerce.sportyshoes.entity.User;
import com.ecommerce.sportyshoes.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

	@Autowired
	OrderService orderService;
	
	//@Test
	public void saveOrderTest() {
		Order order = prepareOrderObject();
		Response response = orderService.saveOrder(order);
		System.out.println(response.getErrorMessage());
		Assert.assertTrue(response != null && SportyShoesConstants.SUCCESS.equals(response.getStatus()));
	}
	
	private Order prepareOrderObject() {
		Order order = new Order();
		User user = new User();
		ProductStock productStock1 = new ProductStock();
	    ProductStock productStock2 = new ProductStock();
	    ProductStock productStock3 = new ProductStock();
		OrderDetails orderDetails1 = new OrderDetails();
		OrderDetails orderDetails2 = new OrderDetails();
	    OrderDetails orderDetails3 = new OrderDetails();
		List<OrderDetails> list = new ArrayList<>();
		Date date = new Date();
		user.setUserId(4l);
		order.setUser(user);
		order.setTotPrice(7799.00);
		order.setTotQuantity(3);
		order.setStatus(OrderStatus.BOOKED);
		order.setBookingTime(date);
		order.setCartId(7l);
		
		productStock1.setSkuId(2l);
		orderDetails1.setProductStock(productStock1);
		orderDetails1.setQuantity(2);
		list.add(orderDetails1);
		
		productStock2.setSkuId(6l);
		orderDetails2.setProductStock(productStock2);
		orderDetails2.setQuantity(3);
		list.add(orderDetails2);
		
		productStock3.setSkuId(2l);
		orderDetails3.setProductStock(productStock3);
		orderDetails3.setQuantity(5);
		list.add(orderDetails3);
		
		order.setOrderDetails(list);
		return order;
	}

	//@Test
	public void getOrderTest() {
		User user = new User();
		Category category = new Category();
		OrderSearchCriteria orderSearchCriteria = new OrderSearchCriteria();
		Date date = new Date();
		user.setUserId(3l);
		category.setCategoryId(2l);
		orderSearchCriteria.setUserId(3l);
		orderSearchCriteria.setCategoryId(2l);
		String sd = "2021-09-27";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			orderSearchCriteria.setFromDate(sdf.parse(sd));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    orderSearchCriteria.setToDate(date);
	    Response response = orderService.getOrder(orderSearchCriteria);
	    System.out.println(response.getData());
		Assert.assertTrue(response != null && SportyShoesConstants.SUCCESS.equals(response.getStatus()));

	}
}
