package com.jrcoppi.twitterSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.jrcoppi.database.Post;


@SpringBootApplication
@ComponentScan(basePackages = { "com.jrcoppi.database","com.jrcoppi.twitterSpring"})
public class TwitterSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterSpringApplication.class, args);

		ApplicationContext applicationContext =
				SpringApplication.run(TwitterSpringApplication.class, args);
		Post conection =
				applicationContext.getBean(Post.class);
		String result = conection.getPesquisa("microsoft");
		System.out.println(result);
		
		System.out.println(conection.insertPost("this  is a test"));
		conection.updatePost("changiing 30", "1");
		conection.deletePost("313");
	}

}