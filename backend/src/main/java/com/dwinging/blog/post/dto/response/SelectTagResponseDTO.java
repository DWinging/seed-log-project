package com.dwinging.blog.post.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SelectTagResponseDTO {
    private String tagName;            // 조회한 태그 이름 (예: "Java")
    private List<PostSummary> posts;   // 이 태그가 달린 게시글들의 요약 리스트

    @Getter
    @AllArgsConstructor
    public static class PostSummary {
        private String title;            // 게시글 제목 리스트의 한 요소
        private LocalDateTime createdAt; // 게시글 작성 시간 리스트의 한 요소
    }
}