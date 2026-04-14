package com.dwinging.blog.post.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dwinging.blog.post.entity.Post;

@Repository
public interface PostSearchRepository extends JpaRepository<Post, Long> {
	
	@EntityGraph(attributePaths = {"mainCategory", "userInfo"})
	Page<Post> findAll(Pageable pageable);  
	
	@Query("select p from Post p " +
			"join fetch p.mainCategory " +
			"join fetch p.userInfo " +
			"where p.mainCategory.id = :mainId and p.isDeleted = false")
	Page<Post> findByMainCategory(@Param("mainId") Long mainId, Pageable pageable);
	
	@Query("select p from Post p " +
			"join fetch p.mainCategory " +
			"join fetch p.userInfo " +
			"where p.mainCategory.id = :mainId and p.subCategory.id = :subId and p.isDeleted = false")
	Page<Post> findBySubCategory(@Param("mainId") Long mainId, @Param("subId") Long subId, Pageable pageable);
	
	@Query("select p from Post p " +
			"join fetch p.mainCategory " + 
			"join fetch p.userInfo " +
			"where p.title like concat('%', :keyword, '%') and p.isDeleted = false")
	Page<Post> findByTitleKeyword(@Param("keyword") String keyword, Pageable pageable);
	
	@Query("select p from Post p " +
			"join fetch p.mainCategory " + 
			"join fetch p.userInfo " +
			"where p.userInfo.userId = :userId and p.isDeleted = false")
	Page<Post> findByUserId(@Param("userId") String userId, Pageable pageable);
}