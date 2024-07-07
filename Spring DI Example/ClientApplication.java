package com.sinan.spring.di.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sinan.spring.di.configuration.DIConfiguration;
import com.sinan.spring.di.consumer.MyApplication;

public class ClientApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
		MyApplication app = context.getBean(MyApplication.class);
		
		app.processMessage("Hi sinan", "sinan@mail.com");
		
		//close the context
		context.close();
	}

}