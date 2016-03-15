package com.cinema.manager.controller;

import com.cinema.manager.controller.service.AuditoriumService;
import com.cinema.manager.controller.service.BookingService;
import com.cinema.manager.controller.service.DiscountService;
import com.cinema.manager.controller.service.EventService;
import com.cinema.manager.controller.service.TicketService;
import com.cinema.manager.controller.service.UserService;

public class ControllerImpl implements Controller {

	private UserService	      userService;
	private AuditoriumService	auditoriumService;
	private EventService	  eventService;
	private BookingService bookingService;
	private DiscountService	  discountService;
	private TicketService ticketService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public AuditoriumService getAuditoriumService() {
		return auditoriumService;
	}

	public void setAuditoriumService(AuditoriumService auditoriumService) {
		this.auditoriumService = auditoriumService;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public BookingService getBookingService() {
		return bookingService;
	}

	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	public DiscountService getDiscountService() {
		return discountService;
	}

	public void setDiscountService(DiscountService discountService) {
		this.discountService = discountService;
	}

	public TicketService getTicketService() {
		return ticketService;
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
}
