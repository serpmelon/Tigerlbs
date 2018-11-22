package com.neuqsoft.mysqlshell.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
//@PropertySource({ "classpath:src/main/resources/app.properties",
//		"classpath:src/main/resources/application.yml" })
public class Properties {

//	@Value("${app.name}")
	private String name;
	
//	@Value("${yml.age}")
	private String age;
	
	public void print() {
		System.out.println("name  " + name);
		System.out.println("age  " + age);
	}
}
