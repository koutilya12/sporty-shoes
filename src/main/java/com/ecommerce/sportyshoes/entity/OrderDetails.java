package com.ecommerce.sportyshoes.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7614693322123768836L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long orderId;
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
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
		return "OrderDetails [id=" + id + ", orderId=" + orderId + ", productStock=" + productStock + ", quantity="
				+ quantity + "]";
	}
}
