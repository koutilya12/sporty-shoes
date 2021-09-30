package com.ecommerce.sportyshoes.constants.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.ecommerce.sportyshoes.constants.UserType;

@Converter(autoApply = true)
public class UserTypeConverter implements AttributeConverter<UserType, String> {

	@Override
	public String convertToDatabaseColumn(UserType attribute) {
		return (attribute == null) ? null : attribute.getValue();
	}

	@Override
	public UserType convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		return (dbData == null) ? null : UserType.getStatus(dbData);
	}

}
