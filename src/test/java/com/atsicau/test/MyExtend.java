package com.atsicau.test;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsicau.extend.ExtendConfig;
import com.atsicau.extend.MyBeanFactoryPostProcessor;

public class MyExtend {

	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtendConfig.class);
	@Test
	public void testExtend(){
		MyBeanFactoryPostProcessor myBeanFactoryPostProcessor = applicationContext.getBean(MyBeanFactoryPostProcessor.class);
		//发布一个事件
		applicationContext.publishEvent(new ApplicationEvent(new String("王怡")) {
		});
		applicationContext.close();
	}
}
