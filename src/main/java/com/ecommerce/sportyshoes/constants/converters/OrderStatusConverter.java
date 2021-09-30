package com.ecommerce.sportyshoes.constants.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.ecommerce.sportyshoes.constants.OrderStatus;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, String> {
	@Override
	public String convertToDatabaseColumn(OrderStatus attribute) {
		return (attribute == null) ? null : attribute.getValue();
	}

	@Override
	public OrderStatus convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		return (dbData == null) ? null : OrderStatus.getStatus(dbData);
	}
}
