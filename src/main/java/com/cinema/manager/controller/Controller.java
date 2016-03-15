package com.cinema.manager.controller;

import com.cinema.manager.controller.service.AuditoriumService;
import com.cinema.manager.controller.service.BookingService;
import com.cinema.manager.controller.service.DiscountService;
import com.cinema.manager.controller.service.EventService;
import com.cinema.manager.controller.service.TicketService;
import com.cinema.manager.controller.service.UserService;

public interface Controller {

	UserService getUserService();
	AuditoriumService getAuditoriumService();
	EventService getEventService();
	BookingService getBookingService();
	DiscountService getDiscountService();
	TicketService getTicketService();
}
