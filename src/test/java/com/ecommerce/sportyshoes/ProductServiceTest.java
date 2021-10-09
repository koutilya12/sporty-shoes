package com.ecommerce.sportyshoes;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.sportyshoes.constants.ProductStatus;
import com.ecommerce.sportyshoes.constants.SportyShoesConstants;
import com.ecommerce.sportyshoes.entity.Brand;
import com.ecommerce.sportyshoes.entity.Category;
import com.ecommerce.sportyshoes.entity.Product;
import com.ecommerce.sportyshoes.entity.ProductStock;
import com.ecommerce.sportyshoes.entity.Response;
import com.ecommerce.sportyshoes.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
	
	@Autowired
	ProductService productService;
	
	
	//@Test
	public void saveProducts() {
		Product product = prepareProductObject();	
		Response response = productService.saveProduct(product);
		Assert.assertTrue(response != null && SportyShoesConstants.SUCCESS.equals(response.getStatus()));
	}
	
	private Product prepareProductObject() {
		Product product = new Product();
		Brand brand = new Brand();
		Category category = new Category();
		product.setProductName("sporty wears2");	
		brand.setBrandId(2l);
		brand.setBrandName("Nike");
		product.setBrand(brand);
		product.setSize(8);
		category.setCategoryId(2l);
		category.setCategoryName("sneakers");
		product.setCategory(category);
		product.setStatus(ProductStatus.ACTIVE);
		return product;
	}

	//@Test
	public void addProductStockTest() {
		Product product = new Product();
		Brand brand = new Brand();
		Category category = new Category();
		product.setProductId(7l);
		ProductStock productStock = new ProductStock();

		productStock.setProduct(product);
		productStock.setStock(24);
		productStock.setBatchNum("10");
		productStock.setPrice(699.00);
		
		Response response = productService.addProductStock(productStock);
		Assert.assertTrue(response != null && SportyShoesConstants.SUCCESS.equals(response.getStatus()));
	}
	
	//@Test
	public void updateProductStockTest() {
		ProductStock productStock = new ProductStock();
		productStock.setSkuId(2l);
		productStock.setStock(10);
		
		Response response = productService.updateProductStock(productStock.getSkuId(), productStock.getStock());
	    Assert.assertTrue(response != null && SportyShoesConstants.SUCCESS.equals(response.getStatus()));
	}
	
	//@Test 
	public void getProductsTest() {
		Product product = new Product();
		product.setProductId(3l);
		//product.setProductName("sneakers M1");
		
		Response response = productService.getProducts(product, 0, 10);
		System.out.println(response.getData());
		Assert.assertTrue(response != null && SportyShoesConstants.SUCCESS.equals(response.getStatus()));
	}
}