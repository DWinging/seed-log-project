package com.dwinging.blog.post.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 블로그의 게시글 정보를 관리하는 핵심 엔티티.
 * <p>게시글의 본문, 생성/수정 시간 및 카테고리, 태그와의 연관 관계를 정의한다. 
 * JPA Auditing을 통해 시간 데이터를 자동으로 관리한다.</p>
 */
@Entity
@Table(name = "Post")
@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class) // 생성/수정 시간 자동 기록을 위한 리스너
public class Post {
	
	/** 게시글 고유 식별자 (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** 게시글 제목 */
	@Column(nullable = false)
	private String title;
	
	/** * 게시글 본문 내용.
	 * <p>대용량 텍스트 저장을 위해 데이터베이스의 TEXT 타입을 사용한다.</p>
	 */
	@Column(columnDefinition = "TEXT")
	private String content;
	
	/** * 게시글 최초 생성 일시.
	 * <p>Spring Data JPA의 @CreatedDate를 통해 자동으로 기록되며, 수정 시 변경되지 않는다.</p>
	 */
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdAt;
	
	/** * 게시글 최종 수정 일시.
	 * <p>@LastModifiedDate를 통해 데이터 수정 시마다 현재 시간으로 갱신된다.</p>
	 */
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	/** * 소속 카테고리 (N:1 양방향 매핑).
	 * <p>연관 관계의 주인이며, 성능 최적화를 위해 지연 로딩(LAZY) 방식을 사용한다.</p>
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	
	/** * 게시글에 포함된 태그 리스트 (중간 테이블 PostTag 활용).
	 * <p>게시글 삭제 시 연관된 태그 연결 정보도 함께 제거(CascadeType.ALL, orphanRemoval)되도록 설정한다.</p>
	 */
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PostTag> postTags = new ArrayList<>();
}