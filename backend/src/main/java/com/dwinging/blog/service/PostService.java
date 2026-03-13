package com.dwinging.blog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dwinging.blog.entity.Post;
import com.dwinging.blog.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
	
	private final PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public Post savePost(Post post) {
		return postRepository.save(post);
	}
	
	public Post updatePost(Post post) {
		return postRepository.save(post);
	}
	
	public void deletePost(Post post) {
		postRepository.delete(post);
	}	
}
