package com.dwinging.blog.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dwinging.blog.post.entity.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    // 현재 추가적인 쿼리 메서드 없이 기본 JpaRepository 기능을 활용함
}