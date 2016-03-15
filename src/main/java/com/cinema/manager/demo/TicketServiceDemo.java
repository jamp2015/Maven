package com.cinema.manager.demo;

import com.cinema.manager.controller.Controller;
import com.cinema.manager.controller.service.TicketService;

public class TicketServiceDemo implements Demo {

	private Controller controller;

	public TicketServiceDemo(Controller controller) {
		this.controller = controller;
	}

	public void execute() {
		TicketService ticketService = controller.getTicketService();

		System.out.println();
		System.out.println("************ TICKET SERVICE DEMO ****************");

		System.out.println("Create a new ticket:");
		ticketService.create(2, "34A", 20000);
		System.out.println(ticketService.getAllTickets());

		System.out.println("Before Delete (ticket id = 2)");
		System.out.println(ticketService.getAllTickets());
		ticketService.delete(2);
		System.out.println("After Delete (ticket id = 2)");
		System.out.println(ticketService.getAllTickets());

		System.out.println("Update ticket id = 2");
		ticketService.update(2, 2, "45", 40000);
		System.out.println(ticketService.getTicket(2));

		System.out.println("Get ticket id = 3");
		System.out.println(ticketService.getTicket(3));

		System.out.println("\nGet ticket (id = 3) price:");
		System.out.println(ticketService.getTicket(4).getPrice());

		System.out.println("Show all tickets");
		System.out.println(ticketService.getAllTickets());
		System.out.println();
	}
}
