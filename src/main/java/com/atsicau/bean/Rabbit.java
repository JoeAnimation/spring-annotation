package com.atsicau.bean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@SuppressWarnings("restriction")
@Component
public class Rabbit {
	
	public Rabbit(){
		System.out.println("Rabbit constructor...");
	}
	//对象创建并赋值之后调用
	@PostConstruct
	public void init(){
		System.out.println("Rabbit...@PostConstructor...");
	}

	@PreDestroy
	public void destroy(){
		System.out.println("Rabbit...destroy...");
	}
}
