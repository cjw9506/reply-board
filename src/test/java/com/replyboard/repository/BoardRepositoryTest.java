package com.replyboard.repository;

import com.replyboard.entity.Board;
import com.replyboard.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired BoardRepository boardRepository;

    @Test
    @Rollback
    public void insertBoard() {
        IntStream.rangeClosed(1,100).forEach(i -> {
            Member member = Member.builder().email("user" + i + "@aaa.com").build();

            Board board = Board.builder()
                    .title("title..." + i)
                    .content("content..." + i)
                    .writer(member)
                    .build();

            boardRepository.save(board);
        });
    }

}