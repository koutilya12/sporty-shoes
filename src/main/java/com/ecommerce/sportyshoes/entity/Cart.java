package com.ecommerce.sportyshoes.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;
	@OneToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;
	private Double totPrice;
	private Integer totQuantity;
	private String status;
	private Date bookingTime;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartId", referencedColumnName = "cartId")
	private List<CartDetails> cartDetails;
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}
	public List<CartDetails> getCartDetails() {
		return cartDetails;
	}
	public void setCartDetails(List<CartDetails> cartDetails) {
		this.cartDetails = cartDetails;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", user=" + user + ", totPrice=" + totPrice + ", totQuantity=" + totQuantity
				+ ", status=" + status + ", bookingTime=" + bookingTime + ", cartDetails=" + cartDetails + "]";
	}
}
