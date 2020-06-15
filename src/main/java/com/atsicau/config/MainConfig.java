package com.atsicau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.atsicau.bean.Person;

/*
 *配置类 == 配置文件
 */
@Configuration
//@ComponentScan(value="com.atsicau",excludeFilters={
//		@Filter(type=FilterType.ANNOTATION,classes={Controller.class,Service.class})
//		})
//@ComponentScan(val="") 指定要扫描的包
//excludeFilters = Filter[],指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[]，指定扫描的只需要加入的组件
//FilterType.ANNOTATION 按照注解
//FilterType.ASSIGNABLE 按照给定的类型
//FilterType.ASPECTJ 使用ASPECTJ的表达式
//FilterType.REGEX 使用正则表达式
//Filter.CUSTOM 适用自定义规则
@ComponentScan(value="com.atsicau",includeFilters={
//	@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
//	@Filter(type=FilterType.ASSIGNABLE_TYPE,classes=Service.class),
	@Filter(type=FilterType.CUSTOM,classes = MyTypeFilter.class)
},useDefaultFilters = false)
public class MainConfig {
	//给容器中注册一个bean 类型为返回值的类型 id默认为方法名
	@Bean("person")
	public Person person(){
		return new Person("文思颖",20,"female");
	}
}
