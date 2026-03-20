package com.dwinging.blog.post.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDetailResponseDTO {
    private Long id;                // 조회 시 식별자
    private String title;
    private String content;
    private String categoryName;    // category 종류
    private List<String> tags;      // tag 목록
    private LocalDateTime updateAt; // 최종 작성 시간
}