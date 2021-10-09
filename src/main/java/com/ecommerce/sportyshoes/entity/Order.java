package com.ecommerce.sportyshoes.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ecommerce.sportyshoes.constants.OrderStatus;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
	@OneToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;
	private Double totPrice;
	private Integer totQuantity;
	private OrderStatus status;
	private Date bookingTime;
	private String transactionId;
	private Long cartId;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId", referencedColumnName = "orderId")
	private List<OrderDetails> orderDetails;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getTotPrice() {
		return totPrice;
	}
	public void setTotPrice(Double totPrice) {
		this.totPrice = totPrice;
	}
	public Integer getTotQuantity() {
		return totQuantity;
	}
	public void setTotQuantity(Integer totQuantity) {
		this.totQuantity = totQuantity;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public Date getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user + ", totPrice=" + totPrice + ", totQuantity="
				+ totQuantity + ", status=" + status + ", bookingTime=" + bookingTime + ", transactionId="
				+ transactionId + ", cartId=" + cartId + ", orderDetails=" + orderDetails + "]";
	}	
}