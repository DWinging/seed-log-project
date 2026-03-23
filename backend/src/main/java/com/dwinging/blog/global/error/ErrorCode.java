package com.dwinging.blog.global.error;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public enum ErrorCode {
	
	INVALID_INPUT_VALUE(400, "C001", "잘못된 입력값 입니다."),
	METHOD_NOT_ALLOED(405, "C002", "허용되지 않는 메서드 입니다."),
	
	POST_NOT_FOUND(404, "P001", "해당 포스트를 찾을 수 없습니다."),
	TAG_NOT_FOUND(404, "T001", "해당 태그를 찾을 수 없습니다."), 
	CATEGORY_NOT_FOUND(404, "CA001", "해당 카테고리를 찾을 수 없습니다.");
	
	private final int status;
	private final String code;
	private final String message;
}
