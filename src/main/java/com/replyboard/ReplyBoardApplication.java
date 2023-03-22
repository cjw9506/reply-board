package com.replyboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ReplyBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReplyBoardApplication.class, args);
	}

}
