package com.atsicau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.atsicau.bean.Love;

/*
 * bean的生命周期：
 *     bean创建-->初始化----->销毁的过程
 * 容器管理bean的生命周期
 * 我们可以自定义初始化和销毁方法，容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 * 
 * 构造(对象创建)
 *     单实例：在容器启动的时候创建对象
 *     多实例：在每次获取的时候创建对象
 * 
 * BeanPostProcessor.postProcessBeforeInitialization
 * 
 * 初始化：
 *     对象创建完成，并赋值好,调用初始化方法
 *     
 * BeanPostProcessor.postProcessAfterInitialization
 * 
 * 销毁：
 * 		单实例Bean在容器关闭时销毁对象
 *      多实例：容器不会管理这个Bean，容器不会调用销毁方法
 * 
 * 
 * 1)指定初始化和销毁方法
 * 		通过@Bean指定init-method和destroy-method
 * 
 * 2)通过让Bean实现InitializingBean(定义初始化逻辑),DisposableBean(定义销毁容器)
 * 
 * 3)可以使用JSR250
 *     @PostConstruct:在bean创建完成并且属性赋值完成来执行初始化
 *     @PreDestroy:在容器销毁Bean之前，通知我们销毁对象
 *     
 *     
 * BeanPostProcessor原理：
 * 		populateBean(beanName, mbd, instanceWrapper);//对bean属性进行赋值(填充属性)
 * 		initializeBean(beanName, exposedObject, mbd);
 * 		{
 * 			applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 * 			invokeInitMethods(beanName, wrappedBean, mbd);//执行自定义初始化
 * 			applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
 * 		}
 *     
 * 4)BeanPostProcessor【interface】:bean的后置处理器
 *    在bean初始化前准备一些处理工作
 *    postProcessBeforeInitialization:初始化之前工作
 *    postProcessAfterInitialization:在初始化之后工作
 *    
 *Spring 底层对BeanPostProcessor的使用
 *			bean赋值，注入其他的组件，@Autowired，生命周期注释功能，@Async,XXXBeanPostProcessor
 */
@ComponentScan("com.atsicau.bean")
@Configuration
public class MyConfigOfLifeCycle {

	@Scope("singleton")
	//@Scope("prototype")
	@Bean(initMethod="init",destroyMethod="destroy")
	public Love love(){
		return new Love();
	}
	
	
}
