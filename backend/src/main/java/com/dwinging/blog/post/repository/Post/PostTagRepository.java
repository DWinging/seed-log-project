package com.dwinging.blog.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dwinging.blog.post.entity.PostTag;

/**
 * 게시글(Post)과 태그(Tag)의 연관 관계 데이터를 관리하는 레포지토리.
 * <p>PostTag 엔티티에 대한 기본적인 CRUD 기능을 제공하며, 
 * 주로 게시글 삭제 시 연관된 태그 연결 정보를 정제하거나 조회할 때 사용된다.</p>
 */
@Repository
public interface PostTagRepository extends JpaRepository<PostTag, Long>{
    // 별도의 쿼리 메서드 정의 없이 JpaRepository의 기본 기능을 상속받아 사용함
}