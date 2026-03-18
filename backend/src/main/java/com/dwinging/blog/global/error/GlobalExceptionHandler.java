package com.dwinging.blog.global.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dwinging.blog.global.error.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<ErrorResponse> handleBusinessExceptoin(BusinessException e) {
		log.error("handleBusinessException", e);
		ErrorCode errorCode = e.getErrorCode();
		ErrorResponse response = ErrorResponse.builder()
				.status(errorCode.getStatus())
				.code(errorCode.getCode())
				.message(errorCode.getMessage())
				.build();
		return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponse> handleException(Exception e) {
		log.error("handleException", e);
		ErrorResponse response = ErrorResponse.builder()
				.status(500)
				.code("INTERNAL_SERVER_ERROR")
				.message("서버 내부 로유가 발생했습니다.")
				.build();
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
