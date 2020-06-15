package com.atsicau.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsicau.aop.MathCalculator;
import com.atsicau.config.MainConfigOfAop;

public class AspectOfAop {
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
	
	@Test
	public void testAop(){
		//不要自己创建对象
		//MathCalculator calculator = new MathCalculator();
		MathCalculator calculator = context.getBean(MathCalculator.class);
		int  k = calculator.div(2, 1);
		System.out.println(k);
		
		context.close();
	}

}
