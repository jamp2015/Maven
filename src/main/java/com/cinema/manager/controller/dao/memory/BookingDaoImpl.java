package com.cinema.manager.controller.dao.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cinema.manager.controller.dao.BookingDao;
import com.cinema.manager.model.Booking;
import com.cinema.manager.model.Ticket;

public class BookingDaoImpl implements BookingDao {

	Map<Integer, Booking>	bookings	= new HashMap<Integer, Booking>();

	public BookingDaoImpl(){
	}

	public BookingDaoImpl(Map<Integer, Booking> bookings) {
		this.bookings = bookings;
	}

	public boolean create(int userId, List<Ticket> tickets) {
		Integer id = generateBookingId();
		Booking booking = new Booking(id, userId, tickets);

		bookings.put(id, booking);
		return true;
	}

	public boolean delete(int id) {
		if (bookings.remove(id) != null) {
			return true;
		}
		return false;
	}

	public boolean update(int id, int userId, List<Ticket> tickets) {
		Booking booking = new Booking(id, userId, tickets);
		if (bookings.put(id, booking) != null) {
			return true;
		}
		return false;
	}

	public Booking getBooking(int id) {
		return bookings.get(id);
	}

	public List<Booking> getAllBookings() {
		List<Booking> items = new ArrayList<Booking>();
		items.addAll(bookings.values());
		return items;
	}

	/**
	 * Generates an id for a booking.
	 *
	 * @return
	 */
	private Integer generateBookingId() {
		Set<Integer> ids = bookings.keySet();
		if (ids.isEmpty()) {
			return 1;
		}
		return Collections.max(ids) + 1;
	}
}
