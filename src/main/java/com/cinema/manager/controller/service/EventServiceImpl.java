package com.cinema.manager.controller.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cinema.manager.controller.dao.EventDao;
import com.cinema.manager.model.Event;
import com.cinema.manager.model.Ratings;

public class EventServiceImpl implements EventService {

	private EventDao	eventDao;

	public EventServiceImpl(EventDao eventDao) {
		super();
		this.eventDao = eventDao;
	}

	public boolean create(String name, Date date, Ratings rating,
	        int auditoriumId) {
		return eventDao.create(name, date, rating, auditoriumId);
	}

	public boolean update(int id, Event event) {
		return eventDao.update(id, event);
	}

	public boolean delete(int id) {
		return eventDao.delete(id);
	}

	public Event getEvent(int id) {
		return eventDao.getEvent(id);
	}

	public List<Event> getByName(String name) {
		return eventDao.getByName(name);
	}

	public List<Event> getAllEvents() {
		return eventDao.getAllEvents();
	}

	public List<Event> getForDateRange(Date fromDate, Date toDate) {
		List<Event> events = new ArrayList<Event>();
		List<Event> allEvents = getAllEvents();

		for (Event event : allEvents) {
			if (event.getDate().after(fromDate)
					&& event.getDate().before(toDate)) {
				events.add(event);
			}
		}
		return events;
	}

	public List<Event> getNextEvents(Date toDate) {
		// Today's date
		Date fromDate = new Date();
		return getForDateRange(fromDate, toDate);
	}

	public boolean bookEventAuditorium(Integer eventId, int auditoriumId) {
		return eventDao.bookEventAuditorium(eventId, auditoriumId);
	}
}
