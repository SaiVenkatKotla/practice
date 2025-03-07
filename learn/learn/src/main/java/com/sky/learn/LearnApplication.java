package com.sky.learn;

import com.sky.learn.service.AccountService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
public class LearnApplication {

	@Autowired
	AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);
	}

}
