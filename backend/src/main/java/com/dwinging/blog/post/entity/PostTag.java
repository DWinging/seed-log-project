package com.dwinging.blog.post.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

/**
 * 게시글(Post)과 태그(Tag) 사이의 다대다(N:M) 관계를 풀어내기 위한 중간 엔티티.
 * <p>하나의 게시글은 여러 태그를 가질 수 있고, 하나의 태그 또한 여러 게시글에 포함될 수 있으므로 
 * 중간 테이블을 통해 일대다-다대일 관계로 매핑한다.</p>
 */
@Entity
@Table(name = "Post_Tag",
		uniqueConstraints = {
				/** 동일한 게시글에 동일한 태그가 중복 생성되는 것을 방지 */
				@UniqueConstraint(columnNames = {"post_id", "tag_id"})
		})
@Getter @Setter
@NoArgsConstructor // JPA 엔티티 영속화를 위한 기본 생성자
public class PostTag {

    /** 중간 테이블 고유 식별자 (PK) */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** * 연결된 게시글 정보 (N:1).
     * <p>성능 최적화를 위해 지연 로딩(LAZY)을 사용하며, 반드시 게시글 정보가 존재해야 한다(nullable = false).</p>
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false) 
    private Post post;

    /** * 연결된 태그 정보 (N:1).
     * <p>성능 최적화를 위해 지연 로딩(LAZY)을 사용하며, 반드시 태그 정보가 존재해야 한다(nullable = false).</p>
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false) 
    private Tag tag;
    
    /**
     * 연관 관계 설정을 위한 편의 생성자.
     * @param post 연결할 게시글 엔티티
     * @param tag  연결할 태그 엔티티
     */
    public PostTag(Post post, Tag tag) {
        this.post = post;
        this.tag = tag;
    }
}