package com.cinema.manager.controller.service;

import java.util.List;

import com.cinema.manager.model.Ticket;
import com.cinema.manager.model.User;

public interface DiscountService {

	/**
	 * Returns discount for each ticket for the user on particular event
	 */
	int getDiscount(User user, List<Ticket> ticketList);

}
