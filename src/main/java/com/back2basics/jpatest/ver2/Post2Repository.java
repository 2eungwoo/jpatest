package com.back2basics.jpatest.ver2;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Post2Repository extends JpaRepository<Post2, Long> {
    List<Post2> findAllByMember2(Member2 member);
    List<Post2> findAllByMember2Id(Long member2Id);
}
