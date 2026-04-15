package com.dwinging.blog.post.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;


/**
 * 게시글의 세부 분류를 나타내는 카테고리
 * <p>게시글(Post)과 1:N 관계를 가지며, 상위 메인 카테고리가 존재한다..</p>
 */
@Entity
@Table(name = "sub_category")
@Getter @Setter
@NoArgsConstructor // JPA 엔티티 영속화를 위한 기본 생성자
public class SubCategory {
	
	/** 카테고리 고유 식별자 (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** * 카테고리 명칭.
	 * 비어 있을 수 없으며(nullable=false).
	 */
	@Column(nullable = false)
	private String name;
	
	/** * 해당 카테고리에 속한 게시글 리스트 (양방향 매핑).
	 * Post 엔티티의 'category' 필드에 의해 관리되는 매핑임을 명시(mappedBy).
	 * 초기화를 통해 NPE(NullPointerException)를 방지함.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "main_category_id")
	private MainCategory mainCategory;
	
	/** * 해당 카테고리에 속한 게시글 리스트 (양방향 매핑).
	 * Post 엔티티의 'subCategory' 필드에 의해 관리되는 매핑임을 명시(mappedBy).
	 * 초기화를 통해 NPE(NullPointerException)를 방지함.
	 */
	@OneToMany(mappedBy = "subCategory")
	private List<Post> posts = new ArrayList<>();
}