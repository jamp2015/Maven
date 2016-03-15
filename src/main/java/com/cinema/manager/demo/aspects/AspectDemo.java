package com.cinema.manager.demo.aspects;

import org.springframework.beans.factory.annotation.Autowired;

import com.cinema.manager.aspects.CounterAspect;
import com.cinema.manager.aspects.DiscountAspect;
import com.cinema.manager.aspects.LuckyWinnerAspect;
import com.cinema.manager.controller.dao.database.CounterDaoImpl;
import com.cinema.manager.demo.Demo;

public class AspectDemo implements Demo {

	private CounterAspect	counterAspect;
	private DiscountAspect discountAspect;
	private LuckyWinnerAspect luckyWinnerAspect;

	@Autowired
	private CounterDaoImpl counterDaoImpl;

	public AspectDemo(CounterAspect counterAspect, DiscountAspect discountAspect, LuckyWinnerAspect luckyWinnerAspect) {
		this.counterAspect = counterAspect;
		this.discountAspect = discountAspect;
		this.luckyWinnerAspect = luckyWinnerAspect;
	}

	public void execute() {

		// Test Counter Aspect
		System.out.println("************** ASPECT DEMO ***************");

		System.out.println("Counters for call of Event.getName():");
		System.out.println(counterAspect.getEventNameCallCounters().toString());

		System.out.println("\nCounters for call of Ticket.getPrice() - EventId and Number of calls:");
		System.out.println(counterAspect.getTicketPriceForEventCounters().toString());

		System.out.println("\nCounters for call of bookings of tickets (the method public void "
				+ "bookTicket(User user, Ticket ticket) in BookingServiceImpl) - EventId and Number of calls:");
		System.out.println(counterAspect.getEventTicketsBookingNumber().toString());

		System.out.println("\nCounters for strategies DiscountStrategy.discount()");
		System.out.println(discountAspect.getDiscountsCounters().toString());

		System.out.println("\nCounters for strategies DiscountStrategy.discount() for a user (userId and his discount strategies calls)");
		System.out.println(discountAspect.getDiscountsForUser().toString());

		System.out.println("\nCounters for booking lucky tickets (userId and his lucky tickets ids)");
		System.out.println(luckyWinnerAspect.getLuckyTickets().toString());

		// Save counters in a database
		counterDaoImpl.updateEventNameCallCounters(counterAspect.getEventNameCallCounters());
		counterDaoImpl.updateTicketPriceForEventCounters(counterAspect.getTicketPriceForEventCounters());
		counterDaoImpl.updateEventTicketsBookingNumber(counterAspect.getEventTicketsBookingNumber());

	}
}
