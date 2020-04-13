package org.ttrung.mai.tool.exception;

import lombok.Getter;

@Getter
public class CredentialException extends GeneralException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5402626905159992789L;
	private String token;

	public CredentialException(String token, String message) {
		super(message);
		this.token = token;

	}

}
