package com.atsicau.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atsicau.config.MainConfig;

public class MainTest {

	public static void main(String[] args) {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		Person person = (Person)ac.getBean("person");
//		System.out.println(person);
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
		Person person = ac.getBean(Person.class);
		System.out.println(person);
		String[] nameForType = ac.getBeanNamesForType(Person.class);
		for(String name : nameForType){
			System.out.println(name);
		}
	}

}
