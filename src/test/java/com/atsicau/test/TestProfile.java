package com.atsicau.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsicau.bean.Love;
import com.atsicau.config.MyConfigOfProfile;

public class TestProfile {

	 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	 
	 //1.使用命令行动态参数:在虚拟机参数位置加载-Dspring.profile.active=环境标识
	 //2.代码的方式激活某种环境：@Profile
	 @Test
	 public void testProfile(){
		 //1.创建一个applicationContext
		 //2.设置需要激活的环境
		 context.getEnvironment().setActiveProfiles("dev","product");
		 //3.注册主配置类
		 context.register(MyConfigOfProfile.class);
		 //4.启动刷新容器
		 context.refresh();
		String[] names =  context.getBeanNamesForType(DataSource.class);
		for(String name : names){
			System.out.println(name);
		}
		Love love = context.getBean(Love.class);
		System.out.println(love);
		context.close();
	 }
}
