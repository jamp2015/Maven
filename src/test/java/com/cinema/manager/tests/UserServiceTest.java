package com.cinema.manager.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cinema.manager.controller.Controller;

public class UserServiceTest {

	@Test
	public void userServiceTest() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");

		Controller controller = (Controller) context.getBean("controller");

		int size = controller.getUserService().getUsersByName("Anna").size();

		String name = controller.getUserService()
				.getUserByEmail("anna@gmail.com").getName();

		assertEquals("Anna", name);
		assertEquals(1, size);

		System.out.println(controller.getUserService().getAllUsers().size());

		context.close();

	}

}
