package com.atsicau.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.atsicau.bean.RainBow;

public class MyImportRegistrar implements ImportBeanDefinitionRegistrar{

	/*
	 * AnnotationMetadata:当前类的注解信息
	 * BeanDefinitionRegistry:BeanDefination的注册类;
	 *     把所有的需要添加到容器中的bean,BeanDefinitionRegistry.registerBeanDefinition自定义注册类
	 * @see org.springframework.context.annotation.ImportBeanDefinitionRegistrar#registerBeanDefinitions(org.springframework.core.type.AnnotationMetadata, org.springframework.beans.factory.support.BeanDefinitionRegistry)
	 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean isHas = registry.containsBeanDefinition("com.atsicau.bean.Color");
		boolean isHas2 = registry.containsBeanDefinition("com.atsicau.bean.Pink");
		
		if(isHas && isHas2){
			//指定Bean定义信息
			RootBeanDefinition definition = new RootBeanDefinition(RainBow.class);
			//注册一个Bean
			registry.registerBeanDefinition("rainBow", definition);
		}
	}

}
