package com.dwinging.blog.domain.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InfoUpdateType {
	PASSWARD("패스워드"),
    NICKNAME("닉니네임"),
    PROFILE_IMAGE("프로필 이미지"),
    BACKGROUND("배경");

    private final String description;
}
