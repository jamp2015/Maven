package com.cinema.manager.controller.dao;

import java.util.List;

import com.cinema.manager.model.Booking;
import com.cinema.manager.model.Ticket;

public interface BookingDao {

	boolean create(int userId, List<Ticket> tickets);

	boolean delete(int id);

	boolean update(int id, int userId, List<Ticket> tickets);

	Booking getBooking(int id);

	List<Booking> getAllBookings();

}
