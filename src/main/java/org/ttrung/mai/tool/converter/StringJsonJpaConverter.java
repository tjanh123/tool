package org.ttrung.mai.tool.converter;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.StringUtils;
import org.ttrung.mai.tool.util.common.ConvertUtil;

import lombok.extern.slf4j.Slf4j;

@Converter
@Slf4j
public class StringJsonJpaConverter implements AttributeConverter<Object, String> {
	
	private static final String DELIMETER = "#------deli-json------#";

	@Override
	public String convertToDatabaseColumn(Object attribute) {
		if(attribute == null) {
			return null;
		}
		String type = attribute.getClass().getName();
		if(Collection.class.isAssignableFrom(attribute.getClass())) {
			Collection collection = (Collection) attribute;
			if(!collection.isEmpty()) {
				Object firstElement = new ArrayList<>(collection).get(0);
				type += DELIMETER + firstElement.getClass().getName();
			}
		}
		return type + DELIMETER + ConvertUtil.toJson(attribute);
	}

	@Override
	public Object convertToEntityAttribute(String dbData) {
		if(StringUtils.isBlank(dbData) || !StringUtils.contains(dbData, DELIMETER)) {
			return null;
		}
		String[] split = dbData.split(DELIMETER);
		if(split.length == 0) {
			return null;
		}
		try {
			if (split.length == 3) {
				return ConvertUtil.fromJsonToCollection(split[2], Class.forName(split[0]), Class.forName(split[1]));
			}
			return ConvertUtil.fromJson(split[1], Class.forName(split[0]));
		} catch (ClassNotFoundException e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

}
