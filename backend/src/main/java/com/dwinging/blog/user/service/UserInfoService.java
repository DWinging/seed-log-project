package com.dwinging.blog.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dwinging.blog.BackendApplication;
import com.dwinging.blog.user.dto.request.SignInDTO;
import com.dwinging.blog.user.dto.request.SignUpDTO;
import com.dwinging.blog.user.dto.request.UpdateRequestDTO;
import com.dwinging.blog.user.dto.response.UserInfoResponse;
import com.dwinging.blog.user.entity.UserImage;
import com.dwinging.blog.user.entity.UserInfo;
import com.dwinging.blog.user.repository.UserImageRepository;
import com.dwinging.blog.user.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserInfoService {
    
    private final UserInfoRepository userInfoRepository;

    @Transactional
    public UserInfoResponse signIn(SignInDTO dto) {
        UserInfo user = userInfoRepository.findByUserId(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));
        
        if(!user.getPassword().equals(dto.getPassword())) {
            throw new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.");
        }
        
        String profileImage = (user.getUserImage() != null) 
                ? user.getUserImage().getProfileImage() 
                : null; 

        return UserInfoResponse.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .profileImage(profileImage)
                .build();
    }

    @Transactional
    public String signUp(SignUpDTO dto) {
        validateDuplicateUser(dto.getUserId());
        
        UserInfo user = UserInfo.builder()
                .userId(dto.getUserId())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
                .build();
                
        return userInfoRepository.save(user).getUserId();
    }

    @Transactional
    public String updateInfo(String id, UpdateRequestDTO dto) {
        UserInfo user = userInfoRepository.findByUserId(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        
        user.update(dto.getNickname(), dto.getProfileImage());
        
        return user.getUserId();
    }

    @Transactional
    public void deleteAccount(String id) {
        UserInfo user = userInfoRepository.findByUserId(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        
        user.delete(); 
    }

    private void validateDuplicateUser(String userId) {
        userInfoRepository.findByUserId(userId)
                .ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 아이디입니다.");
                });
    }
}
