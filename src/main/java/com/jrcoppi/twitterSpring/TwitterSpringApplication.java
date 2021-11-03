package com.jrcoppi.twitterSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.jrcoppi.database.Post;


@SpringBootApplication
@ComponentScan(basePackages = { "com.jrcoppi.database","com.jrcoppi.twitterSpring","com.jrcoppi.rest"})
public class TwitterSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterSpringApplication.class, args);
	}

}
