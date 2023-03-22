package com.replyboard.repository;

import com.replyboard.entity.Board;
import com.replyboard.entity.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyRepositoryTest {

    @Autowired ReplyRepository replyRepository;

    @Test
    @Rollback
    public void insertReply() {

        IntStream.rangeClosed(1, 300).forEach(i -> {

            long id = (long)(Math.random() * 100) + 1;

            Board board = Board.builder().build();

            Reply reply = Reply.builder()
                    .text("reply..." + i)
                    .board(board)
                    .replyer("guest")
                    .build();
            replyRepository.save(reply);
        });
    }

}