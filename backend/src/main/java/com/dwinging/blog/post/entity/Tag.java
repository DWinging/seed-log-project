package com.dwinging.blog.post.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Tag")
@Getter @Setter
@NoArgsConstructor
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "tag")
	private List<PostTag> postTags = new ArrayList<>();
}