package com.dwinging.blog.global.error.exception;

import com.dwinging.blog.global.error.ErrorCode;

public class InvalidValueException extends BusinessException {
	
	private static final long serialVersionUID = 1L;

	public InvalidValueException(ErrorCode errorCode) {
		super(errorCode);
	}
	
	public InvalidValueException(String value, ErrorCode errorCode) {
		super(value + " : " + errorCode.getMessage(), errorCode);
	}

}
