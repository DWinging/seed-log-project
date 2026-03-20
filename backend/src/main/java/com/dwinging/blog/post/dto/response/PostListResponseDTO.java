package com.dwinging.blog.post.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostListResponseDTO {
    private Long id;
    private String title;
    private String categoryName;
    private LocalDateTime createAt;
}