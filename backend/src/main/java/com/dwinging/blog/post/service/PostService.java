package com.dwinging.blog.post.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dwinging.blog.post.entity.Post;
import com.dwinging.blog.post.repository.CategoryRepository;
import com.dwinging.blog.post.repository.PostRepository;
import com.dwinging.blog.post.repository.PostTagRepository;
import com.dwinging.blog.post.repository.TagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	
	private final PostRepository postRepository;
	private final CategoryRepository categoryRepository;
	private final PostTagRepository postTagRepository;
	private final TagRepository tagRepository;
	
	@Transactional
	public Long createPost(Post dto) {
		// TODO
		return dto.getId();
	}
	
	public Post updatePost(Post post) {
		// TODO
		return postRepository.save(post);
	}
	
	public void deletePost(Post post) {
		postRepository.delete(post);
	}
}
