package org.ttrung.mai.tool.exception.authentication;

import org.ttrung.mai.tool.exception.GeneralException;

public class UserNotfoundException extends GeneralException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotfoundException(String email) {
		super("0002", 404, "User " + email + " is not found");
	}

}
