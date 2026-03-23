package com.dwinging.blog.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dwinging.blog.post.entity.Post;

/**
 * Post 엔티티에 대한 데이터베이스 접근 및 영속성 관리를 담당하는 레포지토리.
 * <p>Spring Data JPA의 JpaRepository를 상속받아 기본적인 CRUD(생성, 조회, 수정, 삭제) 
 * 및 페이징, 정렬 기능을 자동으로 제공받는다.</p>
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // 추가적인 쿼리 메서드 정의 없이 JpaRepository의 기본 기능을 활용하여 게시글 데이터를 관리함
}