package com.cinema.manager.aspects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.cinema.manager.controller.service.BookingService;
import com.cinema.manager.model.Ticket;
import com.cinema.manager.model.User;

@Aspect
public class LuckyWinnerAspect {

	// Stores lucky tickets for a user
	// Instead of the requirement "Store the information about this lucky event
	// into the user object (like some system messages or so) - OPTIONAL"

	// userId and ticketsIds
	Map<Integer, List<Integer>> luckyTickets = new HashMap<Integer, List<Integer>>();

	private BookingService bookingService;

	public LuckyWinnerAspect(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}

	public Map<Integer, List<Integer>> getLuckyTickets() {
		return luckyTickets;
	}

	public void setLuckyTickets(Map<Integer, List<Integer>> luckyTickets) {
		this.luckyTickets = luckyTickets;
	}

	@Before("getCheckLucky() && getBookTicket() && args(user, ticket)")
	public void checkLucky(User user, Ticket ticket){

		double limit = 0.5;
		Integer userId = user.getId();

		if (Math.random() < limit){
			if (ticket.getPrice() > 0){
				ticket.setPrice(0);
				bookingService.bookTicket(user, ticket);
			} else {
				return;
			}
			if (!luckyTickets.containsKey(userId)){
				luckyTickets.put(userId, new ArrayList<Integer>());
			}

			luckyTickets.get(userId).add(ticket.getId());
		}
	}

	@Pointcut("within(com.cinema.manager.controller.service.BookingServiceImpl)")
	public void getCheckLucky(){
	}

	@Pointcut("execution(* bookTicket(..))")
	public void getBookTicket() {
	}
}
