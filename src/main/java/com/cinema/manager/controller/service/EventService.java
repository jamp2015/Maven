package com.cinema.manager.controller.service;

import java.util.Date;
import java.util.List;

import com.cinema.manager.model.Event;
import com.cinema.manager.model.Ratings;

public interface EventService {

	boolean create(String name, Date date, Ratings rating, int auditoriumId);

	boolean update(int id, Event event);

	boolean delete(int id);

	Event getEvent(int id);

	List<Event> getByName(String name);

	List<Event> getAllEvents();

	// Assigns auditorium for event
	boolean bookEventAuditorium(Integer eventId, int auditoriumId);

	// Returns events for specified date range
	List<Event> getForDateRange(Date fromDate, Date toDate);

	// Returns events from now till the ‘to’ date
	List<Event> getNextEvents(Date toDate);
}
