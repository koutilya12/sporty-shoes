package com.ecommerce.sportyshoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.sportyshoes.entity.Cart;
import com.ecommerce.sportyshoes.entity.Response;
import com.ecommerce.sportyshoes.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PutMapping("/saveCart")
	public @ResponseBody Response saveUser(@RequestBody Cart cart) {	
		return cartService.saveCart(cart);
		}
	
	@GetMapping("/getCart")
	public @ResponseBody Response getCart(@RequestParam Long userId) {
		return cartService.getCart(userId);
	}
	
	@DeleteMapping("/deleteCart")
	public @ResponseBody Response deleteCart(@RequestParam Long cartId) {
		return cartService.deleteCart(cartId);
	}
}
