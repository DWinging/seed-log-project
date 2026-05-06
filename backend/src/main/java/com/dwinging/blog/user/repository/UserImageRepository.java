package com.dwinging.blog.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dwinging.blog.user.entity.UserImage;
import com.dwinging.blog.user.entity.UserInfo;

@Repository
public interface UserImageRepository extends JpaRepository<UserImage, String>{
	Optional<UserImage> findByUserId(String userId);
}
