package com.atsicau.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//默认加载对象中的组件，容器启动会调用无参构造器创建对象，再进行初始化工作
@Component
public class Girl {
	
	private Love love;
	
	//构造器要用的组件，都是从容器中获取
	//@Autowired
	public Girl(@Autowired Love love){
		this.love = love;
		System.out.println("Girl ...有参构造器...");
	}

	public Love getLove() {
		return love;
	}

	//@Autowired
	//标注在方法上时，Spring容器创建当前对象，就会调用，方法，完成赋值
	//方法使用的参数，自定义类型的IOC容器中获取
	public void setLove(Love love) {
		this.love = love;
	}

	@Override
	public String toString() {
		return "Girl [love=" + love + "]";
	}
	
}
