package com.example.revature.PairedProject_JonathanMuhammad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.example.revature.PairedProject_JonathanMuhammad") //scan com revature package for spring beans
@EntityScan("com.example.revature.PairedProject_JonathanMuhammad.models")
@EnableJpaRepositories("com.example.revature.PairedProject_JonathanMuhammad.repos")
public class PairedProjectJonathanMuhammadApplication {

	public static void main(String[] args) {
		SpringApplication.run(PairedProjectJonathanMuhammadApplication.class, args);
	}

}
