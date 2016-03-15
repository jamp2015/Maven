package com.cinema.manager.controller.dao;

import java.util.Date;
import java.util.List;

import com.cinema.manager.model.Event;
import com.cinema.manager.model.Ratings;

public interface EventDao {

	/**
	 * Create Event with name, air dates and times, base price for tickets,
	 * rating (high, mid, low)
	 *
	 * @param name
	 * @param date
	 * @param ticketPrice
	 * @param rating
	 * @return
	 */
	boolean create(String name, Date date, Ratings rating, int auditoriumId);

	boolean update(int id, Event event);

	boolean delete(int id);

	Event getEvent(int id);

	List<Event> getByName(String name);

	List<Event> getAllEvents();

	// Assigns auditorium for event
	boolean bookEventAuditorium(Integer eventId, int auditoriumId);

}
