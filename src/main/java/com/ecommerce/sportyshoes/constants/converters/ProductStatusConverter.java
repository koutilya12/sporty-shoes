package com.ecommerce.sportyshoes.constants.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.ecommerce.sportyshoes.constants.ProductStatus;

@Converter(autoApply = true)
public class ProductStatusConverter implements AttributeConverter<ProductStatus, String> {

	@Override
	public String convertToDatabaseColumn(ProductStatus attribute) {
		return (attribute == null) ? null : attribute.getValue();
	}

	@Override
	public ProductStatus convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		return (dbData == null) ? null : ProductStatus.getStatus(dbData);
	}
}
