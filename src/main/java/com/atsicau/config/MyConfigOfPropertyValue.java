package com.atsicau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.atsicau.bean.Person;

//使用PropertySouce读取外部配置文件中的属性k/v，然后保存到运行环境变量中；加载完外部配置文件以后使用${}取出配置文件的值
@PropertySource(value={"classpath:/person.properties"})
@Configuration //告诉Spring这是一个配置类
public class MyConfigOfPropertyValue {
	
	@Bean("person")
	public Person person(){
		return new Person();
	}

}
