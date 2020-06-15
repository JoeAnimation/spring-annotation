package com.atsicau.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.atsicau.bean.Person;
import com.atsicau.config.MyConfigOfPropertyValue;

public class PropertyValue {

	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfigOfPropertyValue.class);
	
	@Test
	public void test01(){
		printBeans(context);
		
		Person person = context.getBean(Person.class);
		System.out.println(person);
		
		ConfigurableEnvironment  environment = context.getEnvironment();
		String nickName = environment.getProperty("person.nickName");
		System.out.println(nickName);
		context.close();
	}

	private void printBeans(AnnotationConfigApplicationContext context2) {
		String[] beans = context.getBeanDefinitionNames();
		for(String name : beans){
			System.out.println(name);
		}
	}
}
