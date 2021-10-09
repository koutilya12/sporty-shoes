package com.ecommerce.sportyshoes.entity;

import java.util.Date;

public class OrderSearchCriteria {
	private Long  userId;
	private Long categoryId;
	private Date fromDate;
	private Date toDate;

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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "OrderSearchCriteria [userId=" + userId + ", categoryId=" + categoryId + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + "]";
	}

}
