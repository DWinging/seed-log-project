package com.dwinging.blog.post.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dwinging.blog.global.error.ErrorCode;
import com.dwinging.blog.global.error.exception.BusinessException;
import com.dwinging.blog.post.dto.request.content.CreateRequestDTO;
import com.dwinging.blog.post.dto.request.content.UpdateRequestDTO;
import com.dwinging.blog.post.entity.MainCategory;
import com.dwinging.blog.post.entity.SubCategory;
import com.dwinging.blog.post.entity.Post;
import com.dwinging.blog.post.entity.PostTag;
import com.dwinging.blog.post.entity.Tag;
import com.dwinging.blog.post.repository.Post.MainCategoryRepository;
import com.dwinging.blog.post.repository.Post.PostRepository;
import com.dwinging.blog.post.repository.Post.SubCategoryRepository;
import com.dwinging.blog.post.repository.Post.TagRepository;
import com.dwinging.blog.user.entity.UserInfo;

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
	private final MainCategoryRepository mainCategoryRepository;
	private final SubCategoryRepository subCategoryRepository;
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
		
		UserInfo user = new UserInfo(); // 임시 유저
		
		MainCategory mainCategory = mainCategoryRepository.findById(dto.getMainCategoryId())
				.orElseThrow(() -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));
		
		SubCategory subCategory = subCategoryRepository.findById(dto.getSubCategoryId()).orElse(null);
		
		Post post = new Post(dto.getTitle(), dto.getContent(), user, mainCategory, subCategory);
		
		if(dto.getTags() != null) {
			for(String tagName : dto.getTags()) {
				Tag tag = tagRepository.findByName(tagName)
						.orElseGet(() -> tagRepository.save(new Tag(tagName)));
				
				PostTag postTag = new PostTag(post, tag);
				post.getPostTags().add(postTag);
			}
		}
		
		return postRepository.save(post).getId();
	}
	
	/**
	 * 기존 게시글을 수정한다.
	 * <p>게시글과 카테고리를 조회한 후 필드 값을 변경한다. 
	 * 태그의 경우 기존 연결을 모두 제거하고 새로운 태그 리스트로 재구성한다.</p>
	 * @param id 게시글 식별 번호
	 * @param dto 게시글 수정 요청 데이터
	 * @return 수정된 게시글의 식별자(ID)
	 */
	@Transactional
	public Long updatePost(Long id, UpdateRequestDTO dto) {
		Post post = postRepository.findById(dto.getId())
				.orElseThrow(() -> new BusinessException(ErrorCode.POST_NOT_FOUND));

		MainCategory mainCategory = mainCategoryRepository.findById(dto.getMainCategoryId())
				.orElseThrow(() -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));
		
		SubCategory subCategory = subCategoryRepository.findById(dto.getSubCategoryId()).orElse(null);
		
		post.update(dto.getTitle(), dto.getContent(), mainCategory, subCategory);
		
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
	@Transactional
	public Long deletePost(Long id) {
		Post post = postRepository.findById(id)
				.orElseThrow(() -> new BusinessException(ErrorCode.POST_NOT_FOUND));
		postRepository.delete(post);
		return id;
	}
}