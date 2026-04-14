package com.dwinging.blog.post.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 게시글 상세 조회를 결과를 전달하는 응답 데이터 객체 (DTO)
 * <p>클라이언트가 화면 표시(Name)와 후속 작업(ID)을 모두 수행할 숭 있도록
 * 카테고리의 식별 정보와 표시 정보를 함게 제공한다.</p>
 */
@Getter
@NoArgsConstructor	// JSON 직렬화를 위한 기본 생성자
@AllArgsConstructor // 모든 필드를 포함하는 생성자 (Service 에서 DTO 변환시 사용)
public class PostDetailResponseDTO {
	
	/** 게시글 고유 식별자 */
    private Long id;
    
    /** 게시글 제목 */
    private String title;
    
    /** 게시글 본문 내용 */
    private String content;
    
    /** * 소속된 카테고리의 고유 식별자 (ID)
     * 클라이언트가 수정 요청(update) 등을 보낼 때 다시 서버로 전달하기 위해 필요함
     */
    private Long categoryId;
    
    /** * 소속된 카테고리 이름
     * 엔티티의 Category 객체 대신 이름(String)만 추출하여 전달함으로써 클라이언트의 편의성 증가
     */
    private String categoryName;
    
    /** 게시글에 포함도니 태그 이름 리스트 */
    private List<String> tags;
    
    /** * 최종 수정 일시
     * 사용자가 글을 마지막으로 수정한 시간을 제공함
     */
    private LocalDateTime updateAt;
}