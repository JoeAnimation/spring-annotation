package com.atsicau.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Love implements ApplicationContextAware{
	private ApplicationContext applicationContext;
	public Love(){
		System.out.println("fall in love with...");
	}
	
	public void init(){
		System.out.println("love is init...");
	}
	
	public void destroy(){
		System.out.println("heart is break...");
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
