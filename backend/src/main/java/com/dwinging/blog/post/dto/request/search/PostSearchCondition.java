package com.dwinging.blog.post.dto.request.search;

import com.dwinging.blog.domain.post.entity.SearchType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PostSearchCondition {
	
	private SearchType type;
	
	private Long mainCategoryId;
	private Long subCategoryId;
	
	private String keyword;
	
	private String userId;
}
