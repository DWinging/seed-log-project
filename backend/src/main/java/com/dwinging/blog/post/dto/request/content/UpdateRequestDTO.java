package com.dwinging.blog.post.dto.request;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/** 
 * 기존 게시글 수정을 위한 요청 데이터 객체 전달 (DTO)
 * <p>수정 대상이 되는 게시글의 ID와 변경할 본문 내용, 카테고리, 태그 리스트를 포함한다.</p>
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateRequestDTO {
	
	/** 수정할 게시글의 고유 식별자 (PK) */
	private Long id;
	
	/** 변경할 게시글 제목 */
	private String title;
	
	/** 변경할 게시글 본문 내용 */
	private String content;
	
	/** 새롭게 지정할 카테고리의 고유 식별자 (FK) */
	private Long categoryId;
	
	/** 수정 후 적용할 태그 일므 리스트 (기존 태그를 대체함) */
	private List<String> tags;
	
	/**
	 * 수정을 위한 초기 데이터 설정 생성자
	 * @param title 	  수정할 제목
	 * @param content	  수정할 내용
	 * @param categoryId  변경할 카테고리의 이름
	 * @param tags		  변경할 태그 리스트
	 */
	public UpdateRequestDTO(String title, String content, Long categoryId, List<String> tags) {
		this.title = title;
		this.content = content;
		this.categoryId = categoryId;
		this.tags = tags;
	}
	
	/** 
	 * 컨트롤러에서 경로 변수(@PathVariable)로 받은 ID를 DTO에 바인딩하기 위한 메서드
	 * @param id  수정 대상 게시글 ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
