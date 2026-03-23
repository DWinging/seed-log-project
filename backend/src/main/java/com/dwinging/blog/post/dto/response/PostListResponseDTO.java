package com.dwinging.blog.post.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** 
 * 게시글 목록 조회 시 각 항목의 요약 정보를 전달하는 응답 DTO
 * <p>게시판 리스트 화면 구성에 최적화되어 있으며,
 * 분몬 내용(content)을 제외하여 네트워크 트래픽을 절감한다.</p>
 */
@Getter
@AllArgsConstructor
public class PostListResponseDTO {
	
	/** 게시글 고유 식별자 (상세 페이지 이동 시 링크로 활용) */
    private Long id;
    
    /** 게시글 제목 (목록에 노출되는 메인 텍스트) */
    private String title;
    
    /** * 소속된 카테고리의 이름
     * 목록 화면에서 분류를 직관적으로 보여주기 위해 사용.
     */
    private String categoryName;
    
    /** * 게시글 작성 일시
     * 목록에서 '최신순' 정렬 상태를 사용자에게 시각적으로 전달.
     */
    private LocalDateTime createAt;
}