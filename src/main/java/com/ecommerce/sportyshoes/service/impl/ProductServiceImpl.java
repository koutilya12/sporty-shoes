package com.ecommerce.sportyshoes.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.sportyshoes.constants.SportyShoesConstants;
import com.ecommerce.sportyshoes.dao.BrandDao;
import com.ecommerce.sportyshoes.dao.CategoryDao;
import com.ecommerce.sportyshoes.dao.ProductDao;
import com.ecommerce.sportyshoes.dao.ProductStockDao;
import com.ecommerce.sportyshoes.entity.Brand;
import com.ecommerce.sportyshoes.entity.Category;
import com.ecommerce.sportyshoes.entity.Product;
import com.ecommerce.sportyshoes.entity.ProductStock;
import com.ecommerce.sportyshoes.entity.Response;
import com.ecommerce.sportyshoes.helpers.Validator;
import com.ecommerce.sportyshoes.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ProductStockDao productStockDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	BrandDao brandDao;
	
	@Transactional
	@Override
	public Response saveProduct(Product product) {
		String errorMessage = Validator.validateProduct(product);
		if (errorMessage != null) {
			return new Response(SportyShoesConstants.FAILED, errorMessage);
		}
		validateAndInsertBrand(product);
		validateAndInsertCategory(product);
		productDao.saveAndFlush(product);
		if (product.getProductId() == null) {
			return new Response(SportyShoesConstants.FAILED, "Product save Failed");
		}
		return new Response(SportyShoesConstants.SUCCESS);
	}

	private void validateAndInsertCategory(Product product) {
		Category category = categoryDao.getCategoryByName(product.getCategory().getCategoryName());
		if(category == null) {
			category = categoryDao.saveAndFlush(product.getCategory());
		}
		product.setCategory(category);
	}

	private void validateAndInsertBrand(Product product) {
		Brand brand = brandDao.getBrandByName(product.getBrand().getBrandName());
		if(brand == null) {
			brand = brandDao.saveAndFlush(product.getBrand());
		}
		product.setBrand(brand);

	}

	@Override
	public Response addProductStock(ProductStock productStock) {
		 String errorMessage = Validator.validateProductStock(productStock);
		 if(errorMessage != null) {
			 return new Response(SportyShoesConstants.FAILED, errorMessage);
		 }
		 errorMessage = validateProduct(productStock.getProduct().getProductId());
		 if(errorMessage == null) {
		 productStockDao.save(productStock);
		 if(productStock.getSkuId() == null) {
			 return new Response(SportyShoesConstants.FAILED, "product stock save failed");
		 }
		return new Response(SportyShoesConstants.SUCCESS);
		 } else {
			 return new Response(SportyShoesConstants.FAILED, errorMessage);
		 }
	}

	private String validateProduct(Long productId) {
		if(!productDao.existsById(productId)) {
			return "ProductId not found";
		}
		return null;
	}
	
	@Transactional
	@Override
	public Response updateProductStock(Long skuId, Integer updateQuantity) {
		if(productStockDao.existsById(skuId)) {
			if(productStockDao.updateStock(skuId, updateQuantity) != 0) {
				return new Response(SportyShoesConstants.SUCCESS);
			} else {
				throw new RuntimeException("stock update failed");
			}
		} else {
			return new Response(SportyShoesConstants.FAILED, "Stock not found");
		}
	}

	@Override
	public Response getProducts(Product product, Integer pageNo, Integer pageLimit) {
		String errorMessage = Validator.validateGetProduct(product);
		Page<Product> page;
		if(errorMessage == null) {
			ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAll()
					.withMatcher("productId", ExampleMatcher.GenericPropertyMatchers.exact().ignoreCase())
					.withMatcher("productName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
			Example<Product> example = Example.of(product, customExampleMatcher);
			 if(pageNo != null && pageLimit != null) {
			Pageable pageable = PageRequest.of(pageNo, pageLimit);
			page = productDao.findAll(example, pageable);
			return new Response(SportyShoesConstants.SUCCESS, page.getContent());
			 } else {
					return new Response(SportyShoesConstants.SUCCESS, productDao.findAll(example));
			 }
		}
		return new Response(SportyShoesConstants.FAILED, errorMessage);
	}
}
