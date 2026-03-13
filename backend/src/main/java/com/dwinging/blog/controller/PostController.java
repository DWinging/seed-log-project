package com.dwinging.blog.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dwinging.blog.entity.Post;
import com.dwinging.blog.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
	
	private final PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping
	public String test() {
	    return "서버 연결 성공! 이제 포스트맨으로 POST 요청을 보내보세요.";
	}
	
	@PostMapping
	public Post createPost(@RequestBody Post post) {
		return postService.savePost(post);
	}
	
	@PutMapping("/{id}")
	public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
		return postService.updatePost(post);
	}
	
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable Long id) {
		Post post = new Post();
//		post.setId(id);
		postService.deletePost(post);
	}
}
