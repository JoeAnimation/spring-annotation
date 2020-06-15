package com.atsicau.bean;

import org.springframework.beans.factory.FactoryBean;
//创建一个Spring定义的FactoryBean
public class ColorFactory implements FactoryBean<Color> {

	//返回一个Color对象，这个对象会添加到容器中
	public Color getObject() throws Exception {
		
		return new Color();
	}

	public Class<?> getObjectType() {
		
		return Color.class;
	}

	//控制是否为单例
	//true:bean是单实例，在容器中保存一份
	//false:bean是多实例，每次调用都会在容器中保存一份
	public boolean isSingleton() {
		
		return true;
	}

}
