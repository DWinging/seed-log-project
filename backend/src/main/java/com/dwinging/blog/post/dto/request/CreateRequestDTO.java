package com.dwinging.blog.post.dto.request;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateRequestDTO {
	private String title;
	private String content;
	private Long categoryId;
	private List<String> tags;
	
	public CreateRequestDTO(String title, String content, Long categoryId, List<String> tags) {
		this.title = title;
		this.content = content;
		this.categoryId = categoryId;
		this.tags = tags;
	}
}
