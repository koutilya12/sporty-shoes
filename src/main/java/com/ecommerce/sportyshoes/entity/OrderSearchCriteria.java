package com.ecommerce.sportyshoes.entity;

import java.util.Date;

public class OrderSearchCriteria {
	private User user;
	private Category category;
	private Date fromDate;
	private Date toDate;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	@Override
	public String toString() {
		return "OrderSearchCriteria [user=" + user + ", category=" + category + ", fromDate=" + fromDate + ", toDate="
				+ toDate + "]";
	}
}
