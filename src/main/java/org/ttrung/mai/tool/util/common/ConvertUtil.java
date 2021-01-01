package org.ttrung.mai.tool.util.common;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConvertUtil {

	private static final ObjectMapper mapper = new ObjectMapper()
													.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
													.setSerializationInclusion(Include.NON_EMPTY);
	private ConvertUtil() {
	}

	public static String toJson(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	public static <T> T fromJson(String jsonStr, Class<T> clazz) {
		try {
			return mapper.readValue(jsonStr, clazz);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	public static Map<String, String> fromJsonToSimpleMap(String json) {
		try {
			TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {
			};
			return mapper.readValue(json, typeRef);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	public static <T> List<T> fromJsonToList(String json, Class<T> clazz) {
		try {
			JavaType typeRef = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
			return mapper.readValue(json, typeRef);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	
	public static <T> Collection<T> fromJsonToCollection(String json, Class<?> clazzCollection, Class<T> clazzElement) {
		try {
			JavaType typeRef = null;
			if(Collection.class.isAssignableFrom(clazzCollection)) {
				typeRef = mapper.getTypeFactory().constructCollectionType((Class<? extends Collection>) clazzCollection, clazzElement);
			} else {
				typeRef = mapper.getTypeFactory().constructCollectionType(List.class, clazzElement);
			}
			return mapper.readValue(json, typeRef);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

}
