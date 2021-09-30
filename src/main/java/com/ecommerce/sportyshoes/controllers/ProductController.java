package com.ecommerce.sportyshoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.sportyshoes.entity.Product;
import com.ecommerce.sportyshoes.entity.Response;
import com.ecommerce.sportyshoes.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PutMapping("/saveProduct")
	public @ResponseBody Response saveUser(@RequestBody Product product) {		
		return productService.saveProduct(product);
	}
	
	@GetMapping("/getProducts")
	public @ResponseBody Response getProducts(@RequestBody Product product, @RequestParam Integer pageNo, @RequestParam Integer pageLimit) {
		return productService.getProducts(product, pageNo, pageLimit);
	}
}
