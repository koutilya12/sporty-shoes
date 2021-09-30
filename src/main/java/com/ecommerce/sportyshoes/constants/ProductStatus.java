package com.ecommerce.sportyshoes.constants;

import java.util.stream.Stream;

public enum ProductStatus {
	ACTIVE("A"),
    INACTIVE("I");
	
	private String value;
	
	ProductStatus(String string) {
		this.value = string;
	}
	
	public String getValue() {
		return value;
	}
	
	public static void main(String[] args) {
		
		ProductStatus productStatus = ProductStatus.ACTIVE;
		System.out.println(productStatus.value);
    
	}
	
	public static ProductStatus getStatus(String value) {
		return Stream.of(ProductStatus.values()).filter(c -> c.getValue().equals(value)).findFirst().orElse(null);
	}
}
