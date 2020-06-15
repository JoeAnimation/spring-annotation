package com.atsicau.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.atsicau.bean.Person;
import com.atsicau.bean.Pink;
import com.atsicau.config.MainConfig;
import com.atsicau.config.MyConfig;

public class IOCTest {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//	@Test
//	public void myTest(){
//		String[] define = context.getBeanDefinitionNames();
//		for(String name : define){
//			System.out.println(name);
//		}
//	}
//	
//	@Test
//	public void testMain(){
//		String[] str = context.getBeanDefinitionNames();
//		for(String name : str){
//			System.out.println(name);
//		}
//		
//		Object obj = context.getBean("person");
//		Object obj2 = context.getBean("person");
//		System.out.println(obj == obj2);
//	}

	@Test
	public void testRegist(){
		String[] person = context.getBeanNamesForType(Person.class);
		//动态获取环境变量的值：windows 10
		String version = context.getEnvironment().getProperty("os.name");
		System.out.println(version);
		for(String name : person){
			System.out.println(name);
		}
		Map<String,Person> info = context.getBeansOfType(Person.class);

	}
	@Test
	public void testImport(){
		printBeans(context);
		Pink pink = context.getBean(Pink.class);
		System.out.println(pink);
		Object  obj = context.getBean("colorFactory");
		System.out.println("bean的类型："+obj.getClass());
		Object ob = context.getBean("&colorFactory");
		System.out.println(ob.getClass());
	}
	
	private void printBeans(AnnotationConfigApplicationContext application){
		String[] beans = application.getBeanDefinitionNames();
		for(String name : beans){
			System.out.println(name);
		}
	}
	
}
