package com.sinan.spring.di.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sinan.spring.di.consumer.MyXMLApplication;

public class ClientXMLApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		MyXMLApplication app = context.getBean(MyXMLApplication.class);

		app.processMessage("Hi Sinan", "sinan@mail.com");

		// close the context
		context.close();
	}

}