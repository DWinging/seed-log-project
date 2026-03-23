package com.dwinging.blog.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dwinging.blog.post.entity.Category;

/**
 * Category 엔티티에 대한 데이터베이스 접근 기능을 제공하는 레포지토리 인터페이스.
 * <p>Spring Data JPA의 JpaRepository를 상속받아 기본 CRUD 기능을 자동으로 제공받는다.</p>
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // 현재 추가적인 쿼리 메서드 없이 기본 JpaRepository 기능을 활용함
}