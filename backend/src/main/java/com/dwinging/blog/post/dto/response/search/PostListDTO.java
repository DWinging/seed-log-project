package com.dwinging.blog.post.dto.response.search;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostListDTO {
	
	// 게시글 ID
	private Long id;
	
	// 게시글 제목
	private String title;
	
	// 메인 카테고리 ID
	private Long mainCategoryId;
	
	// 메인 카테고리
	private String mainCategory;
	
	// 글 작성자
	private String author;
	
	// 작성 시간
	private LocalDateTime createdAt;
}
