package org.ttrung.mai.tool.util.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConvertUtil {

	private static ObjectMapper mapper = new ObjectMapper();

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

}
