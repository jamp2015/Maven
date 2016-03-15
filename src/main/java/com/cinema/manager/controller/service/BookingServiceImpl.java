package com.cinema.manager.controller.service;

import java.util.ArrayList;
import java.util.List;

import com.cinema.manager.controller.dao.BookingDao;
import com.cinema.manager.controller.dao.TicketDao;
import com.cinema.manager.model.Booking;
import com.cinema.manager.model.Event;
import com.cinema.manager.model.Ticket;
import com.cinema.manager.model.User;

public class BookingServiceImpl implements BookingService {

	private BookingDao	bookingDao;
	private TicketDao	ticketDao;

	public BookingServiceImpl(BookingDao bookingDao, TicketDao ticketDao) {
		this.bookingDao = bookingDao;
		this.ticketDao = ticketDao;
	}

	public int getTicketPrice(Event event) throws Exception {
		int price = -1;

		List<Ticket> tickets = ticketDao.getAllTickets();
		for (Ticket ticket : tickets) {

			if (event.getId() == ticket.getEventId()) {
				price = ticket.getPrice();
			}
		}
		if (price < 0){
			throw new Exception("Price is unavailable. No ticket was found.");
		}
		return price;
	}

	public void bookTicket(User user, Ticket ticket) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets.add(ticket);
		bookingDao.create(user.getId(), tickets);
	}

	public List<Ticket> getTicketsForEvent(Event event) {
		List<Ticket> tickets = ticketDao.getAllTickets();
		List<Ticket> ticketsForEvent = new ArrayList<Ticket>();

		for (Ticket ticket : tickets) {

			if (event.getId() == ticket.getEventId()) {
				ticketsForEvent.add(ticket);
			}
		}
		return ticketsForEvent;
	}

	public boolean create(int userId, List<Ticket> tickets) {
		return bookingDao.create(userId, tickets);
	}

	public boolean delete(int id) {
		return bookingDao.delete(id);
	}

	public boolean update(int id, int userId, List<Ticket> tickets) {
		return bookingDao.update(id, userId, tickets);
	}

	public Booking getBooking(int id) {
		return bookingDao.getBooking(id);
	}

	public List<Booking> getAllBookings() {
		return bookingDao.getAllBookings();
	}
}
