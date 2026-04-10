package com.dwinging.blog.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "user_image")
@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class UserImage {
	
	@Id
	private String userId;
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId // UserInfo의 PK를 그대로 이 엔티티의 @Id로 매핑하겠다는 선언!
    @JoinColumn(name = "user_id")
    private UserInfo user;
	
	@Column(nullable = true)
	private String profileImage;
	
	@Column(nullable = true)
	private String backgroundImage;
}
