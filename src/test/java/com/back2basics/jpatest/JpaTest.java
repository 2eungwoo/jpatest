package com.back2basics.jpatest;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class JpaTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private MemberRepository memberRepository;

    private Member savedMember;

    @BeforeEach
    void setUp() {
        Member member = new Member();
        member.setEmail("test@example.com");
        savedMember = memberRepository.save(member);

        Post post = new Post();
        post.setMember(savedMember);
        post.setContent("Content");
        postRepository.save(post);
    }

    @AfterEach
    void deleteAll() {
        postRepository.deleteAll();
        memberRepository.deleteAll();
    }

    @Test
    void testFindAllByMemberId() {
        List<Post> posts = postRepository.findAllByMemberId(savedMember.getId());
        assertThat(posts).isNotEmpty();
    }

    @Test
    void testFindAllByMember() {
        List<Post> posts = postRepository.findAllByMember(savedMember);
        assertThat(posts).isNotEmpty();
    }

}
