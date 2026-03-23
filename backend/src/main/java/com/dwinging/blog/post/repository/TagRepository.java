package com.dwinging.blog.post.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dwinging.blog.post.entity.Tag;

/**
 * Tag 엔티티에 대한 데이터베이스 접근 기능을 담당하는 레포지토리.
 * <p>게시글에 부착되는 태그 정보의 CRUD를 처리하며, 
 * 특히 명칭을 통한 중복 체크 및 조회 기능을 제공한다.</p>
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{
	
	/** * 태그 이름을 기반으로 태그 정보를 조회한다.
	 * <p>게시글 작성 시 입력된 태그가 DB에 이미 존재하는지 확인하기 위해 사용된다. 
	 * 조회 결과가 없을 경우를 대비하여 Optional 타입을 반환한다.</p>
	 * @param name 조회하고자 하는 태그 명칭
	 * @return 해당 이름을 가진 태그 정보를 담은 Optional 객체
	 */
	Optional<Tag> findByName(String name);
}