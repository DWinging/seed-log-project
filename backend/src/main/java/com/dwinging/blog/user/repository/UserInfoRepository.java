package com.dwinging.blog.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dwinging.blog.user.entity.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String>{
	// 현재 추가적인 쿼리 메서드 없이 기본 JpaRepository 기능을 활용함
}
