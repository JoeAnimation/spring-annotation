package com.atsicau.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsicau.bean.Color;
import com.atsicau.bean.Girl;
import com.atsicau.bean.Love;
import com.atsicau.config.MainConfigOfAutoWired;
import com.atsicau.dao.BookDao;
import com.atsicau.service.BookService;

public class TestAutoWired {

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutoWired.class);
	
	@Test
	public void test(){
		BookService bookService  = (BookService)context.getBean("bookService");
		
		System.out.println(bookService);
		
		BookDao  bookDao = context.getBean(BookDao.class);
		System.out.println(bookDao);
		
		
		Girl  girl = context.getBean(Girl.class);
		
		System.out.println(girl);
		
		//从容器中获取bean
		Love love = context.getBean(Love.class);
		System.out.println(love);
		
		Color color = context.getBean(Color.class);
		System.out.println(color);
		
		context.close();
	}
}
