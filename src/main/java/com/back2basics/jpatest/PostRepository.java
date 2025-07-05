package com.back2basics.jpatest;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByMember(Member member);
    List<Post> findAllByMemberId(Long memberId);
}