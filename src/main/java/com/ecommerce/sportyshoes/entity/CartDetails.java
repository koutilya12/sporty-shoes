package com.ecommerce.sportyshoes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart_details")
public class CartDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long cartId;
	@OneToOne
	@JoinColumn(name = "skuId", referencedColumnName = "skuId")
	private ProductStock productStock;
	private Integer quantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public ProductStock getProductStock() {
		return productStock;
	}
	public void setProductStock(ProductStock productStock) {
		this.productStock = productStock;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartDetails [id=" + id + ", cartId=" + cartId + ", productStock=" + productStock + ", quantity="
				+ quantity + "]";
	}
	
}

