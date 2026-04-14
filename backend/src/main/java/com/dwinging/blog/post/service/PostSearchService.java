package com.dwinging.blog.post.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dwinging.blog.domain.post.entity.SearchType;
import com.dwinging.blog.post.dto.request.search.PostSearchCondition;
import com.dwinging.blog.post.dto.response.search.PostListDTO;
import com.dwinging.blog.post.entity.Post;
import com.dwinging.blog.post.repository.Post.PostRepository;
import com.dwinging.blog.post.repository.search.PostSearchRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PostSearchService {
	
	private final PostSearchRepository searchRepository;
	
	public Page<PostListDTO> search(PostSearchCondition condition, Pageable pageable) {
		SearchType type = condition.getType();
		
		Page<Post> postPage = null;
		switch (type) {
			case MAIN_CATEGORY: 
				postPage = searchRepository.findByMainCategory(condition.getMainCategoryId(), pageable);
				break;
			case SUB_CATEGORY:
				postPage = searchRepository.findBySubCategory(condition.getMainCategoryId(), condition.getSubCategoryId(), pageable);
				break;
			case TITLE:
				postPage = searchRepository.findByTitleKeyword(condition.getKeyword(), pageable);
				break;
			case AUTHOR:
				postPage = searchRepository.findByUserId(condition.getUserId(), pageable);
				break;
			default:
				postPage = searchRepository.findAll(pageable);
				break;
		}
			
		return postPage.map(post -> PostListDTO.builder()
				.id(post.getId())
				.mainCategoryId(post.getMainCategory().getId()) 
			    .mainCategory(post.getMainCategory().getName())
				.title(post.getTitle())
				.author(post.getUser().getUser_id())
				.createdAt(post.getCreatedAt())
				.build());
	}
}
