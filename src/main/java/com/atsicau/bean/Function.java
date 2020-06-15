package com.atsicau.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class Function implements ApplicationContextAware,BeanNameAware,EmbeddedValueResolverAware{
	
	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("传入的IOC:"+applicationContext);
		this.applicationContext = applicationContext;
	}

	public void setBeanName(String name) {
		System.out.println("传入当前的bean名字："+name);
		
	}

	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		String resolverStringValue = resolver.resolveStringValue("hello ${os.name} 我是:#{20*18}");
		System.out.println("解析的字符串："+resolverStringValue);
	}

}
