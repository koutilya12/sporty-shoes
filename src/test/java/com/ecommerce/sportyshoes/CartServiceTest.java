package com.ecommerce.sportyshoes;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.sportyshoes.constants.SportyShoesConstants;
import com.ecommerce.sportyshoes.entity.Cart;
import com.ecommerce.sportyshoes.entity.CartDetails;
import com.ecommerce.sportyshoes.entity.OrderDetails;
import com.ecommerce.sportyshoes.entity.ProductStock;
import com.ecommerce.sportyshoes.entity.Response;
import com.ecommerce.sportyshoes.entity.User;
import com.ecommerce.sportyshoes.service.CartService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTest {
	
	@Autowired
	CartService cartService;
	
	//@Test
	public void saveCartTest() {
		Cart cart = prepareCartObject();
		Response response = cartService.saveCart(cart);
		System.out.println(response);
		Assert.assertTrue(response != null && SportyShoesConstants.SUCCESS.equals(response.getStatus()));
	}
	
	private Cart prepareCartObject() {
		  User user = new User();
	      Cart cart = new Cart();
	      CartDetails cartDetails1 = new CartDetails();
	      CartDetails cartDetails2 = new CartDetails();
	      CartDetails cartDetails3 = new CartDetails();
	      ProductStock productStock1 = new ProductStock();
	      ProductStock productStock2 = new ProductStock();
	      ProductStock productStock3 = new ProductStock();
		  List<CartDetails> list = new ArrayList<>();
		  
		  user.setUserId(3l);
		  cart.setUser(user);
		  cart.setTotPrice(1500.00);
		  cart.setTotQuantity(3);
		  cart.setStatus("A");
		  cart.setBookingTime(new Date());
		  
		  productStock1.setSkuId(2l);
		  cartDetails1.setProductStock(productStock1);
		  cartDetails1.setQuantity(3);
		  list.add(cartDetails1);
		  
		  productStock2.setSkuId(2l);
		  cartDetails2.setProductStock(productStock2);
		  cartDetails2.setQuantity(2);
		  list.add(cartDetails2);
		  
		  productStock3.setSkuId(2l);
		  cartDetails3.setProductStock(productStock3);
		  cartDetails3.setQuantity(5);
		  list.add(cartDetails3);

		  cart.setCartDetails(list);
		return cart;
	}

	//@Test
	public void getCartTest() {
	    Response response = (Response) cartService.getCart(3l);
		Assert.assertTrue(response != null && SportyShoesConstants.SUCCESS.equals(response.getStatus()));

	}
	
	//@Test
	public void deleteCartTest() {
		Response response = cartService.deleteCart(7l);
		System.out.println(response);
		Assert.assertTrue(response != null && SportyShoesConstants.SUCCESS.equals(response.getStatus()));

	}
}
