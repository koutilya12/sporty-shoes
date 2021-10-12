package com.ecommerce.sportyshoes.service;

import com.ecommerce.sportyshoes.entity.Product;
import com.ecommerce.sportyshoes.entity.ProductStock;
import com.ecommerce.sportyshoes.entity.Response;

public interface ProductService {
	/**
	 * Insert new products
	 * @param product
	 * @return Success message if saved successfully else error message
	 */
	public Response saveProduct(Product product);
	/**
	 * Add product to the stock
	 * @param productStock
	 * @return Success message if added successfully else error message
	 */
	public Response addProductStock(ProductStock productStock);
	/**
	 * Update products stock
	 * @param product
	 * @return Success message if updated successfully else error message
	 */
	public Response updateProductStock(Long skuId, Integer updateQuantity); 
	/**
	 * get required products
	 * @param product
	 * @return List  of products else error message
	 */
	public Response getProducts(Product product, Integer pageNo, Integer pageLimit);
}
