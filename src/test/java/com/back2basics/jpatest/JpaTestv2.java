package com.back2basics.jpatest;

import static org.assertj.core.api.Assertions.assertThat;

import com.back2basics.jpatest.ver1.Member;
import com.back2basics.jpatest.ver1.MemberRepository;
import com.back2basics.jpatest.ver1.Post;
import com.back2basics.jpatest.ver1.PostRepository;
import com.back2basics.jpatest.ver2.Member2;
import com.back2basics.jpatest.ver2.Member2Repository;
import com.back2basics.jpatest.ver2.Post2;
import com.back2basics.jpatest.ver2.Post2Repository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class JpaTestv2 {


    @Autowired
    private Post2Repository post2Repository;

    @Autowired
    private Member2Repository member2Repository;

    private Member2 savedMember2;

    @BeforeEach
    void setUp() {
        Member2 member2 = new Member2();
        member2.setEmail("test2@example.com");
        savedMember2 = member2Repository.save(member2);

        Post2 post2 = new Post2();
        post2.setMember2(savedMember2);
        post2.setContent("Content2");
        post2Repository.save(post2);
    }

    @AfterEach
    void tearDown() {
        post2Repository.deleteAll();
        member2Repository.deleteAll();
    }

    @Test
    void testFindAllByMemberId() {
        List<Post2> posts = post2Repository.findAllByMember2Id(savedMember2.getId());
        assertThat(posts).isNotEmpty();
    }

    @Test
    void testFindAllByMember() {
        List<Post2> posts = post2Repository.findAllByMember2(savedMember2);
        assertThat(posts).isNotEmpty();
    }
}