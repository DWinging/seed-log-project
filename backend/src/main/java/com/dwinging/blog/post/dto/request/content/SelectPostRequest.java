package com.dwinging.blog.post.dto.request;

import lombok.Getter;
import lombok.Setter;

/** 
 * 게시글 조회를 위한 검색 조건 전달 객체 (DTO)
 * <p>특정 게시글의 ID, 제목 키워드, 혹은 카테고리 식별자를 활용하여
 * 필터링된 게시글 목록을 조회할 때 사용된다. </p>
 */
@Getter @Setter
public class SelectPostRequest {
    
	/** * 특정 게시글의 고유 식별자(PK)
     * 단건 조회나 특정 ID 기반 필터링 시 사용
     */
	private Long id;
	
	/** * 검색할 제목 키워드
	 * 해당 키워드가 포함된 게시글을 검색할 때 사용 (LIKE 검색 등)
	 */
    private String title;
    
    /** * 조회의 기준이 되는 카테고리 고유 식별자 (PK)
     * 특정 카테고리에 속한 게시글만 모아보기 할 때 사용
     */
    private Long categoryId;
}