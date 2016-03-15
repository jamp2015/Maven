package com.cinema.manager.demo;

import java.util.Date;

import com.cinema.manager.controller.Controller;
import com.cinema.manager.controller.service.UserService;
import com.cinema.manager.model.User;

public class UserServiceDemo implements Demo {

	private Controller controller;

	public UserServiceDemo(Controller controller) {
		this.controller = controller;
	}

	public void execute() {
		System.out.println("************* USER SERVICE DEMO ****************");
		System.out.println("Get all users:");
		UserService userService = controller.getUserService();
		System.out.println(userService.getAllUsers());

		System.out.println("Get users by name: Anna");
		System.out.println(userService.getUsersByName("Anna"));

		System.out.println("Get users by email: anna@gmail.com");
		System.out.println(userService.getUserByEmail("anna@gmail.com"));

		userService.create("John", "john@gmail.com", new Date());

		System.out.println("Get users by id: 2");
		System.out.println(userService.getUser(2));

		userService.delete(2);
		System.out.println("Get all users:");
		System.out.println(userService.getAllUsers());

		// Update user
		final User user = userService.getUser(1);
		user.setEmail("newemail@gmail.com");
		userService.update(user);
		System.out.println(userService.getUser(1));


	}
}
