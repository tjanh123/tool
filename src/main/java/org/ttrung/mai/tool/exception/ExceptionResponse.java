package org.ttrung.mai.tool.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExceptionResponse {
	private final String code;
	private final String message;
}
