package com.ecommerce.sportyshoes.service;

import com.ecommerce.sportyshoes.entity.Cart;
import com.ecommerce.sportyshoes.entity.Response;

public interface CartService {
	/**
	 * save items cart
	 * @param cart
	 * @return Success message if cart saved successfully else error message
	 */
	public Response saveCart(Cart cart); 
	/**
	 * get items from the cart
	 * @param userId
	 * @return List of items in cart if found else error message
	 */
	public Response getCart(Long userId);
	/**
	 * update items in cart
	 * @param cartId
	 * @return Success message if cart is updated successfully else error message
	 */
	public Response deleteCart(Long cartId);
}
