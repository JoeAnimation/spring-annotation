package com.atsicau.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsicau.config.MyConfigOfLifeCycle;

public class TestLoveCycle {
	//创建基于注解的IOC容器
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfigOfLifeCycle.class);
	@Test
	public void test(){
		System.out.println("Love is begining...");
		
		//多实例下只有在调用的时候才会触发调用对象的行为
		context.getBean("love");
		
		//关闭容器
		context.close();
	}

}
