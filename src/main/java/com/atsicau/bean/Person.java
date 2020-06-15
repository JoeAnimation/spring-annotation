package com.atsicau.bean;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;

public class Person implements Serializable {
	
	//使用@Value
	//1.基本数值
	//2.可以写SpEl:#{}
	//3.可以写${},取出配置文件【properties】中的值(在运行环境变量的值)
	
	private static final long serialVersionUID = 7166174335115954200L;
	
	@Value(value = "陈开婷")
	private String name;
	@Value("#{22-3}")
	private Integer age;
	@Value(value="female")
	private String gender;
	@Value("${person.nickName}")
	private String nickName;
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Person() {
		super();
		
	}
	public Person(String name, Integer age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", nickName=" + nickName + "]";
	}
	
}
