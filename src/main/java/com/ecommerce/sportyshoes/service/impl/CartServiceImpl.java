package com.ecommerce.sportyshoes.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.sportyshoes.constants.SportyShoesConstants;
import com.ecommerce.sportyshoes.dao.CartDao;
import com.ecommerce.sportyshoes.entity.Cart;
import com.ecommerce.sportyshoes.entity.Response;
import com.ecommerce.sportyshoes.helpers.Validator;
import com.ecommerce.sportyshoes.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartDao cartDao;
	
	@Override
	public Response saveCart(Cart cart) {
		String errorMessage = Validator.validateCart(cart);
		if(errorMessage != null) {
			return new Response(SportyShoesConstants.FAILED, errorMessage);
		}
		cart.setBookingTime(new Date());
		cartDao.saveAndFlush(cart);
		if(cart.getCartId() == null) {
			return new Response(SportyShoesConstants.FAILED, "cart not saved");
		} else {
			return new Response(SportyShoesConstants.SUCCESS);
		}	
  }

	@Override
	public Response getCart(Long userId) {
		String errorMessage = Validator.validateUserId(userId);
		if(errorMessage != null) {
			return new Response(SportyShoesConstants.FAILED, errorMessage);
		}
		List<Cart> list = cartDao.getCart(userId);
		System.out.println(list);
		if(list != null && list.get(0) != null) {
			return new Response(SportyShoesConstants.SUCCESS, list);
		} else {
			return new Response(SportyShoesConstants.FAILED, "Cart not available");
		}
	}

	@Override
	public Response deleteCart(Long cartId) {
		  String errorMessage = Validator.validateCartId(cartId);
		  if(errorMessage != null) {
			  return new Response(SportyShoesConstants.FAILED, errorMessage);
		  }
		  if(cartDao.existsById(cartId)) {
		  cartDao.deleteById(cartId);
		  if(!cartDao.existsById(cartId)){
			  return new Response(SportyShoesConstants.SUCCESS, "Cart deleted successfully");
		  } else { 
			  return new Response(SportyShoesConstants.FAILED, "Delete cart failed");
		  }
	   } else {
		   return new Response(SportyShoesConstants.FAILED, "Cart Id not available");
	   }
	}
}
