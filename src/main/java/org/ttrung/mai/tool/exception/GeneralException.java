package org.ttrung.mai.tool.exception;

import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3546913050304852214L;

	private final String code;
	private final int status;

	public GeneralException(String code, int status, String message) {
		super(message);
		this.code = code;
		this.status = status;
	}

}
