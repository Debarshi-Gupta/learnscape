package com.debarshi.learnscape;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.debarshi.learnscape.repository")
@EntityScan("com.debarshi.learnscape.model")
public class LearnscapeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnscapeApplication.class, args);
	}

}
