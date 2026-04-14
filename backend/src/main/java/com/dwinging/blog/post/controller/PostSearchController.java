package com.dwinging.blog.post.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.RequiredArgsConstructor;

import com.dwinging.blog.post.dto.request.search.PostSearchCondition;
import com.dwinging.blog.post.dto.response.search.PostListDTO;
import com.dwinging.blog.post.service.PostSearchService;

@RestController
@RequestMapping("/api/posts/search")
@RequiredArgsConstructor
public class PostSearchController {
	private final PostSearchService postSearchService;
	
	@GetMapping
	public ResponseEntity<Page<PostListDTO>> searchPost(
			@ModelAttribute PostSearchCondition condition,
			Pageable pageable) {
		Page<PostListDTO> results = postSearchService.search(condition, pageable);
		return ResponseEntity.ok(results);
	}
}
