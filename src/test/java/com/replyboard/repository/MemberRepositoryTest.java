package com.replyboard.repository;

import com.replyboard.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Rollback
    public void insertMembers() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member member = Member.builder()
                    .email("user" + i + "@aaa.com")
                    .password("1111")
                    .name("USER" + i)
                    .build();

            memberRepository.save(member);
        });
    }

    @Test
    public void insert() {
        Member member = Member.builder().email("aaa").build();
        memberRepository.save(member);
    }

}