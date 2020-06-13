package org.ttrung.mai.tool.util.common;

import org.apache.commons.lang3.StringUtils;

public class GenericUtil {

	public static <T> T getValueOrDefault(T value, T defaultValue) {
		return value == null || StringUtils.isBlank(value.toString())? defaultValue : value;
	}
}
