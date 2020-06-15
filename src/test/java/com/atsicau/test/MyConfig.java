package com.atsicau.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsicau.transaction.TransactionConfig;
import com.atsicau.transaction.UserService;

public class MyConfig {

	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TransactionConfig.class);
	@Test
	public void addUser(){
		UserService userService = applicationContext.getBean(UserService.class);
		userService.insertUser();
	}
}
