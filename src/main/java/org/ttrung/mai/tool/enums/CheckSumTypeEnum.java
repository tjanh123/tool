package org.ttrung.mai.tool.enums;

public enum CheckSumTypeEnum {
	MD5("MD5"), SHA1("SHA-1"), SHA256("SHA-256"), SHA384("SHA-384"), SHA512("SHA-512");

	private final String value;

	private CheckSumTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
