package com.jrcoppi.twitterSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("repository")
@EntityScan("entity")
@ComponentScan(basePackages = { "entity","repository","com.jrcoppi.database","com.jrcoppi.twitterSpring","com.jrcoppi.rest"})

public class TwitterSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterSpringApplication.class, args);
	}

}
