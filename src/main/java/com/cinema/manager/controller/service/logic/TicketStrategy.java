package com.cinema.manager.controller.service.logic;

import java.util.List;

import com.cinema.manager.model.Ticket;
import com.cinema.manager.model.User;

public class TicketStrategy implements DiscountStrategy {

	private static final int TICKET_LIMIT_FOR_DISCOUNT = 5; // 10

	public int discount(User user, List<Ticket> tickets) {
		int counter = 1;
		double totalDiscount = 0.0;

		for (Ticket ticket : tickets){
			if (counter % TICKET_LIMIT_FOR_DISCOUNT == 0)
			{
				totalDiscount += 0.5*ticket.getPrice();
			}
			counter++;
		}
		return (int)totalDiscount;
	}

}
