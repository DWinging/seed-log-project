package com.dwinging.blog.global.error;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
	
	private final LocalDateTime timestamp = LocalDateTime.now();
	private final int status;		// HTTP 상태 코드 (예 : 400, 404)
	private final String code;		// 비지니스 에러 코드 (예 : POST_NOT_FOUND)
	private final String message;	// 에러 메시지
	
}
