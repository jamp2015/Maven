package com.cinema.manager.demo;

import java.text.ParseException;
import java.util.Date;

import com.cinema.manager.controller.Controller;
import com.cinema.manager.controller.service.EventService;
import com.cinema.manager.model.Event;
import com.cinema.manager.model.Ratings;
import com.cinema.manager.utils.DateConverterUtil;

public class EventServiceDemo implements Demo {

	private Controller controller;

	public EventServiceDemo(Controller controller) {
		super();
		this.controller = controller;
	}

	public void execute() {

		System.out.println();
		System.out.println("************* EVENT SERVICE DEMO ****************");

		EventService eventService = controller.getEventService();

		System.out.println("Create event");
		eventService.create("Gladiator", new Date(), Ratings.HIGH, 2);
		System.out.println("Show events after creation:");
		System.out.println(eventService.getAllEvents());

		System.out.println("Update event");
		Event event = eventService.getEvent(5);
		event.setAuditoriumId(1);
		eventService.update(5, event);
		System.out.println(eventService.getEvent(5));

		System.out.println("Delete event id = 1");
		eventService.delete(1);
		System.out.println("Show events after creation:");
		System.out.println(eventService.getAllEvents());

		System.out.println("Show event id = 4");
		eventService.getEvent(4);

		System.out.println("Get event by name - Gladiator:");
		eventService.getByName("Gladiator");

		System.out.println("Show all events:");
		System.out.println(eventService.getAllEvents());

		// Assigns auditorium for event
		eventService.bookEventAuditorium(3, 4);

		try {
			// Returns events for specified date range
			Date fromDate = DateConverterUtil.getSimpleDate("2015-10-01 00:00:00.0");
			Date toDate = DateConverterUtil.getSimpleDate("2015-10-18 00:00:00.0");
			System.out.println("Events for a range of dates (should be empty if no changes in the data):");
			System.out.println(eventService.getForDateRange(fromDate, toDate));

			// Returns events for specified date range
			fromDate = DateConverterUtil.getSimpleDate("2015-11-01 00:00:00.0");
			toDate = DateConverterUtil.getSimpleDate("2015-11-18 00:00:00.0");
			System.out.println("Events for a range of dates:");
			System.out.println(eventService.getForDateRange(fromDate, toDate));

			// Returns events from now till the ‘to’ date
			toDate = DateConverterUtil.getSimpleDate("2015-12-10 00:00:00.0");
			System.out.println(eventService.getNextEvents(toDate));

		} catch (ParseException e) {
			System.out.println("Error when parsing dates.");
			e.printStackTrace();
		}
	}
}
