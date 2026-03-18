package com.dwinging.blog.global.error.exception;

import com.dwinging.blog.global.error.ErrorCode;

public class EntityNotFoundException extends BusinessException{
	
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}
}