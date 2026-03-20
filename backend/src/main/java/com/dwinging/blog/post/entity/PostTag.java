package com.dwinging.blog.post.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "Post_Tag",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {"post_id", "tag_id"})
		})
@Getter @Setter
@NoArgsConstructor
public class PostTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false) 
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false) 
    private Tag tag;
    
    public PostTag(Post post, Tag tag) {
    	this.post = post;
    	this.tag = tag;
    }
}