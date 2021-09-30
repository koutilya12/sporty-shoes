package com.ecommerce.sportyshoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.sportyshoes.entity.ProductStock;
import com.ecommerce.sportyshoes.entity.Response;
import com.ecommerce.sportyshoes.service.ProductService;

@Controller
public class ProductStockController {
	
	@Autowired
	ProductService productService;
	
	@PutMapping("/addProductStock")
	public @ResponseBody Response addProductStock(@RequestBody ProductStock productStock) {
		return productService.addProductStock(productStock);
	}
	
	@PutMapping("/updateProductStock")
	public @ResponseBody Response updateProductStock(@RequestParam(value="skuId", required=false)Long skuId, @RequestParam(value="updateQuantity", required=false)Integer updateQauntity) {
		return productService.updateProductStock(skuId, updateQauntity);
	}
}
