package com.cnu.real_coding_server.repository;

import com.cnu.real_coding_server.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    // JPA repository를 상속받고 저장할 객체가 무엇인지, id값이 무엇인지만 해 놓으면
    // 아래는 아래 메소드를 작성하지 않아도 제공해줌

//    Post save(Post post);
//    List<Post> findAll();
//    Optional<Post> findById(Integer postId);
//    void delete(Post post);
}
