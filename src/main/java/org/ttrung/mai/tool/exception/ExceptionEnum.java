package org.ttrung.mai.tool.exception;

import static lombok.AccessLevel.PRIVATE;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class ExceptionEnum {

	public static final GeneralException INTERNAL_ERROR = new GeneralException("0001", 500, "Something went wrong");
}
