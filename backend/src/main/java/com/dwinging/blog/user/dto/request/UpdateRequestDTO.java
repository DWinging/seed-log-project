package com.dwinging.blog.user.dto.request;

import com.dwinging.blog.domain.user.entity.InfoUpdateType;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateRequestDTO {
	
	private InfoUpdateType type;

	private String password;
	
	private String nickname;
	
	private String profileImage;
	
	private String backgroundImage;
}
