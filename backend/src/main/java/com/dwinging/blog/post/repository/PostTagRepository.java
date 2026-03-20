package com.dwinging.blog.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dwinging.blog.post.entity.PostTag;

@Repository
public interface PostTagRepository extends JpaRepository<PostTag, Long>{

}
