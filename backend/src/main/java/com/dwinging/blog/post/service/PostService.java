package com.dwinging.blog.post.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dwinging.blog.global.error.ErrorCode;
import com.dwinging.blog.global.error.exception.BusinessException;
import com.dwinging.blog.post.dto.request.CreateRequestDTO;
import com.dwinging.blog.post.dto.request.UpdateRequestDTO;
import com.dwinging.blog.post.entity.Category;
import com.dwinging.blog.post.entity.Post;
import com.dwinging.blog.post.entity.PostTag;
import com.dwinging.blog.post.entity.Tag;
import com.dwinging.blog.post.repository.CategoryRepository;
import com.dwinging.blog.post.repository.PostRepository;
import com.dwinging.blog.post.repository.TagRepository;

import lombok.RequiredArgsConstructor;

/**
 * 게시글 관련 비즈니스 로직을 처리하는 서비스 클래스.
 * <p>게시글의 생성, 수정, 삭제 기능을 제공하며, 
 * 카테고리와 태그 등 연관된 엔티티와의 정합성을 관리한다.</p>
 */
@Service
@RequiredArgsConstructor
public class PostService {
	
	private final PostRepository postRepository;
	private final CategoryRepository categoryRepository;
	private final TagRepository tagRepository;
	
	/**
	 * 새로운 게시글을 등록한다.
	 * <p>카테고리 존재 여부를 확인하고, 태그 리스트를 순회하며 
	 * 기존 태그를 사용하거나 새 태그를 생성하여 연결한다.</p>
	 * @param dto 게시글 생성 요청 데이터
	 * @return 생성된 게시글의 식별자(ID)
	 */
	@Transactional
	public Long createPost(CreateRequestDTO dto) {
		
		// 1. 카테고리 검증 및 조회
		Category category = categoryRepository.findById(dto.getCategoryId())
				.orElseThrow(() -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));
		
		// 2. 게시글 엔티티 생성 및 기본 정보 설정
		Post post = new Post();
		post.setTitle(dto.getTitle());
		post.setContent(dto.getContent());
		post.setCategory(category);
		
		// 3. 태그 처리: 존재하면 가져오고 없으면 생성하여 중간 테이블(PostTag)로 연결
		if(dto.getTags() != null) {
			for(String tagName : dto.getTags()) {
				Tag tag = tagRepository.findByName(tagName)
						.orElseGet(() -> tagRepository.save(new Tag(tagName)));
				
				PostTag postTag = new PostTag(post, tag);
				post.getPostTags().add(postTag);
			}
		}
		
		// 4. 저장 후 생성된 ID 반환
		return postRepository.save(post).getId();
	}
	
	/**
	 * 기존 게시글을 수정한다.
	 * <p>게시글과 카테고리를 조회한 후 필드 값을 변경한다. 
	 * 태그의 경우 기존 연결을 모두 제거하고 새로운 태그 리스트로 재구성한다.</p>
	 * @param dto 게시글 수정 요청 데이터
	 * @return 수정된 게시글의 식별자(ID)
	 */
	public Long updatePost(UpdateRequestDTO dto) {
		// 1. 수정 대상 게시글 조회
		Post post = postRepository.findById(dto.getId())
				.orElseThrow(() -> new BusinessException(ErrorCode.POST_NOT_FOUND));

		// 2. 변경할 카테고리 검증
		Category category = categoryRepository.findById(dto.getCategoryId())
				.orElseThrow(() -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));

		// 3. 데이터 업데이트
		post.setTitle(dto.getTitle());
		post.setContent(dto.getContent());
		post.setCategory(category);
	
		// 4. 태그 리스트 갱신: 기존 관계 초기화 후 다시 매핑
		if(dto.getTags() != null) {
			post.getPostTags().clear();
			
			for(String tagName : dto.getTags()) {
				Tag tag = tagRepository.findByName(tagName)
						.orElseGet(() -> tagRepository.save(new Tag(tagName)));
				
				PostTag postTag = new PostTag(post, tag);
				post.getPostTags().add(postTag);
			}
		}
		
		return post.getId();
	}
	
	/**
	 * 특정 게시글을 삭제한다.
	 * @param id 삭제할 게시글의 식별자
	 */
	public void deletePost(Long id) {
		Post post = postRepository.findById(id)
				.orElseThrow(() -> new BusinessException(ErrorCode.POST_NOT_FOUND));
		postRepository.delete(post);
	}
}