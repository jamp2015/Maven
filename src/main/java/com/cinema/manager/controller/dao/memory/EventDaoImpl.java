package com.cinema.manager.controller.dao.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.cinema.manager.controller.dao.EventDao;
import com.cinema.manager.model.Event;
import com.cinema.manager.model.Ratings;
import com.cinema.manager.utils.DateConverterUtil;

public class EventDaoImpl implements EventDao {

	// Holds auditorium info. Injected by Spring
	private Map<Integer, Event>	events	= new HashMap<Integer, Event>();

	public EventDaoImpl(Map<Integer, Event> events) {
		super();
		this.events = events;
	}

	public EventDaoImpl(List<Properties> eventProps) throws Exception {

		// Fill the map with events
		for (Properties props : eventProps) {

			Integer id = Integer.parseInt(props.getProperty("id"));
			String name = props.getProperty("name");
			Date date = DateConverterUtil.getSimpleDate(props.getProperty("date"));
			Ratings rating = Ratings.valueOf(props.getProperty("rating"));
			int auditoriumId = Integer.parseInt(props.getProperty("auditoriumId"));

			Event event = new Event(id, name, date, rating, auditoriumId);
			events.put(id, event);
		}
	}


	public Map<Integer, Event> getEvents() {
		return events;
	}

	public void setEvents(Map<Integer, Event> events) {
		this.events = events;
	}

	public boolean create(String name, Date date, Ratings rating,
			int auditoriumId) {

		Integer id = generateId();
		Event event = new Event(id, name, date, rating, auditoriumId);
		events.put(id, event);
		return true;
	}

	public boolean update(int id, Event event) {
		Event updatedEvent = events.put(id, event);
		if (updatedEvent != null) {
			return true;
		}
		return false;
	}

	public boolean delete(int id) {
		Event event = events.remove(id);
		if (event != null) {
			return true;
		}
		return false;
	}

	public Event getEvent(int id) {
		return events.get(id);
	}

	public List<Event> getByName(String name) {
		if (name == null || events.entrySet().isEmpty()) {
			return null;
		}
		Event event;
		List<Event> eventList = new ArrayList<Event>();

		for (Map.Entry<Integer, Event> entry : events.entrySet()) {
			event = entry.getValue();
			if (name.equals(event.getName())) {
				eventList.add(event);
			}
		}
		return eventList;
	}

	public List<Event> getAllEvents() {
		List<Event> evnetList = new ArrayList<Event>();
		evnetList.addAll(events.values());
		return evnetList;
	}

	public boolean bookEventAuditorium(Integer eventId, int auditoriumId) {
		Event event = events.get(eventId);
		if (event != null) {
			event.setAuditoriumId(auditoriumId);
			return true;
		}
		return false;
	}

	/**
	 * Generates an id for an event.
	 *
	 * @return
	 */
	private Integer generateId() {
		Set<Integer> ids = events.keySet();
		if (ids.isEmpty()) {
			return 1;
		}
		return Collections.max(ids) + 1;
	}
}
