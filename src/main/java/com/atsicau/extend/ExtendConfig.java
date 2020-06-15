package com.atsicau.extend;

import java.util.EventListener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/*
 * 扩展的原理：
 * BeanPostProcessor,bean后置处理器，bean创建对象初始化前后进行拦截工作
 * BeanFactoryPostProcessor:beanFactory的后置处理器
 * 	     在BeanFactory标准初始化之后调用，所有的bean定义已经保存加载到beanFactory中，但是Bean的实例还未创建
 * 1)IOC容器创建对象
 * 2)invokeBeanFactoryPostProcessors(beanFactory);执行BeanFactoryPostProcessor;
 * 	如何找到所有的BeanFactoryProcessor并执行它们的方法
 * 		invokeBeanFactoryPostProcessors
 * 		1)直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件，并执行它们的方法
 * 		2)在初始化创建其他组件前面执行
 * 
 * 2.BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 * 		postProcessBeanDefinitionRegistry
 * 		在所有bean定义信息将要被加载，但是这些bean实例还没有被初始化完成
 * 		
 * 		优先于BeanFactoryPostProcessor执行，利用BeanDefinitionRegistryPostProcessor给容器中再添加一些额外的组件
 * 	
 * 原理：
 * 		1)创建IOC对象
 * 		2)refresh()->invokeBeanFactoryPostProcessor(beanFactory)
 * 		3)先从容器中获取到BeanDefinitionRegistryPostPorcessor组件，依次触发所有的postProcessBeanDefinitionRegistry()方法
 * 			1)依次触发postProcessBeanDefinitionRegistry()方法
 * 			2)再来触发postProcessBeanFactory()方法BeanFactoryPostProcessor;
 * 		4)再来从容器中找到BeanFactoryPostProcessor组件，然后依次触发postProcessBeanFactory()方法。
 *
 *3.ApplicationListener:监听容器中发布的事件，完成事件驱动模型的开发
 *	public interface ApplicationListener<E extends ApplicationEvent> extends EventListener
 *	监听 ApplicationEvent 及其下面的子事件	
 *步骤：
 *	1)写一个监听器来监听某个事件(ApplicationEvent及其子类)
 *		@EventListener:让任意方法都可以监听组件
 *		原理：使用EventListenerMethosProcessor处理器来解析方法上的@EventListener
 *	2)把监听器加入到容器
 *	3)只要容器中有相关事件的发布，我们就能监听到这个事件
 *	 	ContextRefeshedEvent:容器刷新完成(所有的bean都完全创建)会发布这个事件
 *		ContextClosedEvent：关闭容器会发布这个事件
 *	4)发布一个事件：
 *		applicationContext.publishEvent()
 *原理：
 *	ContextRefreshedEvent、MyExtend$1[source=王怡]、ContextClosedEvent
 *	1)ContextRefreshedEvent事件：
 *	  1)容器创建对象：refresh();
 *	  2)finishRefresh(),容器刷新完成,会发布ContextRefreshEvent事件
 *2)自己发布事件
 *3)容器关闭会发布ContextClosedEvent
 *
 *【事件发布流程】：
 *	  3)publishEvent(new ContextRefreshedEvent(this));
 *			1)获取事件的多播器(派发器),getApplicationEventListener()
 *			2)multicastEvent派发事件：
 *			3)获取到所有的ApplicationListener
 *				for(final ApplicationListener<?> listener : getApplicationListeners(event,type);
 *				1)如果有Executor,可以支持使用Executor异步派发
 *					Executor executor = getTaskExecutor()
 *				2)否则，同步的方式直接执行Listener()方法 invokeListener(listener, event);
 *					拿到listener回调onApplicationEvent方法
 *【事件多播器(派发器)】
 *		1)容器创建对象：refresh()
 *		initApplicationEventMulticaster();初始化ApplicationEventMulticaster
 *		   1)先去容器中找有没有id="applicationEventMulticaster"组件
 *		   2)如果没有，则自己创建一个(this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory));;
 *			并且加入到容器中，我们就可以在其他组件要派发事件的时候，我们只需要自动注入applicationEventMulticaster
 *			
 *【容器中有哪些监听器】
 *	1)容器创建对象:refresh()
 *	2)registerListeners();注册所有的监听器
 *		从容器中拿到所有的监听器，把他们注册到applicationEventMulticaster中
 *		String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false)
 *		将listener注册到ApplicationEventMulticaster中
 *		getApplicationEventMulticasteer().addApplicationListenerBean(listenerBeanName);
 *SmartInitializingSingleton原理：->afterSingletonsInstantiated()
 *	1)ioc容器创建对象并refresh()
 *	2)finishBeanFactoryInitialization(beanFactory)，初始化剩下的单实例bean
 *		1)先创建所有的单实例bean，调用getBean()创建
 *		2)获取所有创建好的单实例bean,判断是否是SmartInitializingSingleton;
 *			如果是就调用afterSingletonsInstatntiated();
 */

import com.atsicau.bean.Cat;
import com.atsicau.bean.Love;
@ComponentScan("com.atsicau.extend")
@Configuration
public class ExtendConfig {

	@Bean
	public Love love(){
		return new Love();
	}
	@Bean
	public Cat cat(){
		return new 	Cat();
	}
}