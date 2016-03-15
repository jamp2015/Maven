package com.cinema.manager.controller.dao;

import java.util.Map;

public interface CountersDao {

	boolean updateEventNameCallCounters(Map<String, Integer>	eventNameCallCounters);
	boolean updateTicketPriceForEventCounters(Map<Integer, Integer>	ticketPriceForEventCounters);
	boolean updateEventTicketsBookingNumber(Map<Integer, Integer>	eventTicketsBookingNumber);

}
