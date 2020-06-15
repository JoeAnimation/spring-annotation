package com.atsicau.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean,DisposableBean{
	
	public Cat(){
		System.out.println("Cat constructor...");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("cat afterPropertiesSet...");
		
	}

	public void destroy() throws Exception {
		System.out.println("life is destroying...");
		
	}

}
