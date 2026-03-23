package com.dwinging.blog.post.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dwinging.blog.post.dto.request.CreateRequestDTO;
import com.dwinging.blog.post.dto.request.UpdateRequestDTO;
import com.dwinging.blog.post.entity.Post;
import com.dwinging.blog.post.service.PostService;

import lombok.RequiredArgsConstructor;


/**
 * 게시글 관련 API를 제공하는 컨트롤러
 * 사용자의 HTTP 요청을 수신하여 PostService에 비지니스 로직을 위임함
 */
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
	
	private final PostService postService;
	
	/**
	 * 서버 연결 상태를 확인하기 위한 테스트 엔드 포인트
	 * @return 연결 성공 메시지
	 */
	@GetMapping
	public String test() {
	    return "서버 연결 성공! 이제 포스트맨으로 POST 요청을 보내보세요.";
	}
	
	/**
	 * 새로운 글을 생성한다.
	 * @param dto 게시글 생성에 필요한 데이터 (제목, 내용, 카테고리 ID, 태그 등) 
	 * @return 생성된 게시글의 고유 식별자
	 */
	@PostMapping
	public Long createPost(@RequestBody CreateRequestDTO dto) {
		// 엔티티 대신 DTO를 직접 전달하여 캡슐화 유지
		return postService.createPost(dto);
	}
	
	/**
	 * 기존 글을 수정한다.
	 * @param id 수정할 게시글의 ID
	 * @param dto 수정할 데이터 정보
	 * @return 수정 완료된 게시글의 ID
	 */
	@PutMapping("/{id}")
	public Long updatePost(@PathVariable Long id, @RequestBody UpdateRequestDTO dto) {
		// DTO에 ID를 세팅
		dto.setId(id);
		return postService.updatePost(dto);
	}
	
	/**
	 * 특정 게시글을 삭제한다.
	 * @param id 삭제할 게시글의 ID
	 */
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable Long id) {
		postService.deletePost(id);
	}
}
