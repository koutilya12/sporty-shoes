package com.ecommerce.sportyshoes.constants;

import java.util.stream.Stream;

public enum OrderStatus {
	
	BOOKED("B"),
    CANCELLED("C");
	
	private String value;
	
	OrderStatus(String string) {
		this.value = string;
	}
	
	public String getValue() {
		return value;
	}
	
	public static void main(String[] args) {
		
		OrderStatus orderStatus = OrderStatus.BOOKED;
		System.out.println(orderStatus.value);
    
	}
	
	public static OrderStatus getStatus(String value) {
		return Stream.of(OrderStatus.values()).filter(c -> c.getValue().equals(value)).findFirst().orElse(null);
	}
    
}
