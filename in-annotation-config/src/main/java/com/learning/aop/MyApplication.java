package com.learning.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.aop.business.Business;

@SpringBootApplication
public class MyApplication {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) SpringApplication.run(MyApplication.class, args);
		Business business =  context.getBean(Business.class);
		System.out.println(business.getClass());
	}
}
