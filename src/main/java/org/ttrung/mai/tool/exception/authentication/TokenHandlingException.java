package org.ttrung.mai.tool.exception.authentication;

import org.ttrung.mai.tool.exception.GeneralException;

public class TokenHandlingException extends GeneralException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TokenHandlingException(String token) {
		super("0003", 500, "Error when handling token: " + token);
	}

}
