package com.atsicau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.atsicau.bean.Color;
import com.atsicau.bean.ColorFactory;
import com.atsicau.bean.Person;
import com.atsicau.condition.LinuxCondition;
import com.atsicau.condition.MyImportRegistrar;
import com.atsicau.condition.MyImportSelector;
import com.atsicau.condition.WindowCondition;

//只有当前系统为windows，下面的配置才有效
@Conditional(value = { WindowCondition.class })
@Configuration
@Import(value = { Color.class,MyImportSelector.class,MyImportRegistrar.class })
public class MyConfig {

	/*
	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
	 * 
	 * prototype:多实例 ioc容器启动并不会去调用对象放在容器中，每次获取时才会调用方法创建对象
	 * singleton:单实例(默认值) ioc容器启动会调用方法创建对象到ioc容器中
	 * 
	 * 懒加载：
	 *  	单实例bean，默认在容器启动的时候创建对象，
	 *  	懒加载：容器启动不创建对象，第一次使用(获取)bean时创建对象，并初始化
	 */
	//@Scope("prototype")
	@Lazy
	@Scope("singleton")
	@Bean("person")
	public Person person(){
		return new Person("张安静",19,"female");
	}
	
	/*
	 * @Conditional({}),按照一定的条件进行判断，满足条件给容器中注册bean
	 * 如果是windows系统，则注入("bill")
	 * 如果是linux系统，则注入("chenting")
	 */
	
	@Bean("bill")
	public Person person01(){
		return new Person("Bill Gates",62,"male");
	}
	
	@Conditional(value={LinuxCondition.class})
	@Bean("chenting")
	public Person person02(){
		return new Person("陈婷",20,"female");
	}
	/*
	 * 给容器中注册组件
	 * 1)包扫描+组件标注注解(@Controller,/@Service/@Repository)
	 * 2)@Bean[导入第三包里面的组件]
	 * 3)@Import[快速的给容器中导入一个组件]
	 *    1)@Import(要导入容器中的组件),容器就会自动注册这个组件，id默认是全类名
	 *    2)ImportSelector：返回需要返回的字符数组
	 *    3)ImportBeanDefinitionRegistrar:手动注册bean到容器中
	 *   
	 * 4)使用Spring提供的FactoryBean(工厂Bean)
	 *    1)默认获取到的是bean调用getObject创建的对象
	 *    2)加前缀&便能够正常获取到Bean工厂本身
	 */
	@Bean
	public ColorFactory colorFactory(){
		return new ColorFactory();
	}
}
