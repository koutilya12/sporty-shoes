package com.ecommerce.sportyshoes.constants.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.ecommerce.sportyshoes.constants.UserStatus;

@Converter(autoApply = true)
public class UserStatusConverter implements AttributeConverter<UserStatus, String> {
	@Override
	public String convertToDatabaseColumn(UserStatus attribute) {
		return (attribute == null) ? null : attribute.getValue();
	}

	@Override
	public UserStatus convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		return (dbData == null) ? null : UserStatus.getStatus(dbData);
	}

}
