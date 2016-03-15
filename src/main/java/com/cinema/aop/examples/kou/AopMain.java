package com.cinema.aop.examples.kou;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cinema.aop.examples.kou.model.Circle;
import com.cinema.aop.examples.kou.model.User;
import com.cinema.aop.examples.kou.service.ShapeService;
import com.cinema.aop.examples.kou.service.UserService;
import com.cinema.manager.model.Event;
import com.cinema.manager.model.Ratings;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/cinema/aop/examples/kou/spring-kou.xml");

		ShapeService shapeService = ctx.getBean("shapeService",
				ShapeService.class);

		shapeService.getCircle().setName("Circle 2");
		// System.out.println(shapeService.getCircle().getName());
		// System.out.println(shapeService.getTriangle().getName());

		// Circle circle = ctx.getBean("circle", Circle.class);

		Circle circle = new Circle();
		circle.getName();

		Event event = new Event(23, "qwrqwe", new Date(), Ratings.HIGH, 2356);
		event.getName();


		UserService userService = ctx.getBean("userService", UserService.class);
		userService.setUser(new User(1, "Peter"));

	}
}
