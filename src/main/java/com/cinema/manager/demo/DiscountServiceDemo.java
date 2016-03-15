package com.cinema.manager.demo;

import java.util.List;

import com.cinema.manager.controller.Controller;
import com.cinema.manager.controller.service.DiscountService;
import com.cinema.manager.model.Ticket;
import com.cinema.manager.model.User;

public class DiscountServiceDemo implements Demo {

	private Controller controller;

	public DiscountServiceDemo(Controller controller) {
		super();
		this.controller = controller;
	}

	public void execute() {
		System.out.println();
		System.out.println("************* DISCOUNT SERVICE DEMO ****************");
		DiscountService discountService = controller.getDiscountService();

		User user = controller.getUserService().getUser(1);
		List<Ticket> ticketList = controller.getTicketService().getAllTickets();

		System.out.println("Total discount: " + discountService.getDiscount(user, ticketList));

		user = controller.getUserService().getUser(4);
		ticketList = controller.getTicketService().getAllTickets();

		System.out.println("Total discount: " + discountService.getDiscount(user, ticketList));

		// Set the current day and month for this user to demonstrate BirthdayStrategy (see user_3.properties)
		user = controller.getUserService().getUser(3);
		ticketList = controller.getTicketService().getAllTickets();

		System.out.println("Total discount: " + discountService.getDiscount(user, ticketList));
	}
}
