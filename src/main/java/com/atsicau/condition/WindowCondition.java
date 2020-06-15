package com.atsicau.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断操作系统是否为windows
public class WindowCondition implements Condition{

	/*
	 * ConditionContext:判断条件能否使用的上下文(环境)
	 * AnnotatedTypeMetadata:注释信息
	 * @see org.springframework.context.annotation.Condition#matches(org.springframework.context.annotation.ConditionContext, org.springframework.core.type.AnnotatedTypeMetadata)
	 */
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//判断是否为linux系统
		//1.能获取到ioc的beanFactory
		ConfigurableListableBeanFactory  factory = context.getBeanFactory();
		//2.获取类加载器
		ClassLoader loader = context.getClassLoader();
		//3.获取当前环境信息
		Environment environment = context.getEnvironment();
		//4.注册一个bean的定义
		BeanDefinitionRegistry  bean= context.getRegistry();
		//判断容器中bean的注册情况
		boolean definition = bean.containsBeanDefinition("person");
		
		//5.
		String version = environment.getProperty("os.name");
		if(version.contains("Windows 10")){
			return true;
		}
		return false;
	}
	
}
