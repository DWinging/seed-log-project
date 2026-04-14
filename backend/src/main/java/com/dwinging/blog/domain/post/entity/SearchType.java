package com.dwinging.blog.domain.post.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SearchType {
    MAIN_CATEGORY("메인 카테고리"),
    SUB_CATEGORY("서브 카테고리"),
    TITLE("제목 검색"),
    AUTHOR("작성자 검색"),
    ALL("전체 검색");

    private final String description;
}
