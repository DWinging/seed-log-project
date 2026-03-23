package com.dwinging.blog.post.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

/**
 * 게시글에 부여되는 태그 정보를 관리하는 엔티티.
 * <p>태그 명칭은 고유(Unique)해야 하며, PostTag 중간 엔티티를 통해 
 * 게시글(Post)과 다대다(N:M) 관계를 형성한다.</p>
 */
@Entity
@Table(name = "Tag")
@Getter @Setter
@NoArgsConstructor // JPA 영속성 관리를 위한 기본 생성자
public class Tag {

	/** 태그 고유 식별자 (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** * 태그 명칭.
	 * <p>동일한 이름의 태그가 중복 생성되는 것을 방지하기 위해 unique 제약 조건을 설정한다.</p>
	 */
	@Column(nullable = false, unique = true)
	private String name;
	
	/** * 해당 태그가 포함된 게시글과의 연결 정보 리스트.
	 * <p>PostTag 엔티티의 'tag' 필드에 의해 매핑되는 양방향 관계이다.</p>
	 */
	@OneToMany(mappedBy = "tag")
	private List<PostTag> postTags = new ArrayList<>();
	
	/**
	 * 새로운 태그를 생성하기 위한 생성자.
	 * @param name 생성할 태그의 명칭
	 */
	public Tag(String name) {
		this.name = name;
	}
}