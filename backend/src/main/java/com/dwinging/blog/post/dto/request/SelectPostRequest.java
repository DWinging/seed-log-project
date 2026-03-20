package com.dwinging.blog.post.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectPostRequest {
    private Long id;         // 특정 글 번호로 조회할 때
    private String title;    // 제목 키워드로 검색할 때
    private Long categoryId; // 카테고리 검색
}