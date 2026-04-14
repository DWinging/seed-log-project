package com.dwinging.blog.post.dto.request;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 게시글 생성을 위한 요청 데이터 전달 객체 (DTO)
 * <p>클라이언트로 부터 전달받은 JSON 데이터를 객체화하며,
 * 게시글의 기본 정보와 연관도니 카테고리 및 태그 리스트를 포함한다.</p>
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateRequestDTO {
	
	/** 게시글의 제목 */
	private String title;
	
	/** 게시글 본문 내용 (TEXT 타입 매핑) */
	private String content;
	
	/** 연결할 카테고리의 고유 식별자 */
	private Long categoryId;
	
	/** 게시글에 부여할 태그 이름 리스트 */
	private List<String> tags;
	
	/** 
	 * 모든 필드를 포함하는 생성자
	 * 테스트 코드 작성이나 내부 객체 생성시 사용된다.
	 * @param title			게시글 제목
	 * @param content		게시글 내용
	 * @param categoryId	연관 카테고리 ID
	 * @param tags			태그 문자열 리스트
	 */
	public CreateRequestDTO(String title, String content, Long categoryId, List<String> tags) {
		this.title = title;
		this.content = content;
		this.categoryId = categoryId;
		this.tags = tags;
	}
}
