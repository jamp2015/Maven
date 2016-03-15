package com.cinema.manager.controller.service;

import java.util.List;

import com.cinema.manager.model.Booking;
import com.cinema.manager.model.Event;
import com.cinema.manager.model.Ticket;
import com.cinema.manager.model.User;

public interface BookingService {

	/**
	 * Returns price for ticket for specified event on specific date and time
	 * for specified seats
	 *
	 * @param event
	 * @param auditorium
	 * @param user
	 * @return
	 */
	int getTicketPrice(Event event) throws Exception;

	/**
	 * User could be registered or not. If user is registered, then booking
	 * information is stored for that user. Purchased tickets for particular
	 * event should be stored
	 *
	 * @param user
	 * @param ticket
	 */
	void bookTicket(User user, Ticket ticket);

	/**
	 * Get all purchased tickets for event for specific date
	 *
	 * @param event
	 * @return
	 */
	List<Ticket> getTicketsForEvent(Event event);

	boolean create(int userId, List<Ticket> tickets);

	boolean delete(int id);

	boolean update(int id, int userId, List<Ticket> tickets);

	Booking getBooking(int id);

	List<Booking> getAllBookings();
}
