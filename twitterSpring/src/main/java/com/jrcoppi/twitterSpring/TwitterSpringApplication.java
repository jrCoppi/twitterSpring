package com.jrcoppi.twitterSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.jrcoppi.database.Conection;


@SpringBootApplication
@ComponentScan(basePackages = { "com.jrcoppi.database","com.jrcoppi.twitterSpring"})
public class TwitterSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterSpringApplication.class, args);

		ApplicationContext applicationContext =
				SpringApplication.run(TwitterSpringApplication.class, args);
		Conection conection =
				applicationContext.getBean(Conection.class);
		String result = conection.Search("teste");

		System.out.println(result);
	}

}
