package com.cinema.manager.controller.dao.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.cinema.manager.controller.dao.TicketDao;
import com.cinema.manager.model.Ticket;

public class TicketDaoImpl implements TicketDao {

	Map<Integer, Ticket>	tickets	= new HashMap<Integer, Ticket>();

	public TicketDaoImpl(Map<Integer, Ticket> tickets) {
		this.tickets = tickets;
	}

	/**
	 * Constructor.
	 *
	 * @param auditoriumProps
	 *            properties
	 * @throws Exception
	 */
	public TicketDaoImpl(List<Properties> ticketProps) throws Exception {

		// Fill the map with auditoriums.
		for (Properties props : ticketProps) {
			Integer id = Integer.parseInt(props.getProperty("id"));
			int eventId = Integer.parseInt(props.getProperty("eventId"));
			String seats = props.getProperty("seats");
			int price = Integer.parseInt(props.getProperty("price"));

			// String id = generateAuditoriumId();
			Ticket ticket = new Ticket(id, eventId, seats, price);
			tickets.put(id, ticket);
		}
	}

	public boolean create(int eventId, String seats, int price) {
		Integer id = generateId();
		Ticket ticket = new Ticket(id, eventId, seats, price);

		tickets.put(id, ticket);
		return true;
	}

	public boolean delete(int id) {
		if (tickets.remove(id) != null) {
			return true;
		}
		return false;
	}

	public boolean update(int id, int eventId, String seats, int price) {
		Ticket ticket = new Ticket(id, eventId, seats, price);
		if (tickets.put(id, ticket) != null) {
			return true;
		}
		return false;
	}

	public Ticket getTicket(int id) {
		return tickets.get(id);
	}

	public List<Ticket> getAllTickets() {
		List<Ticket> items = new ArrayList<Ticket>();
		items.addAll(tickets.values());
		return items;
	}

	/**
	 * Generates an id for a ticket.
	 *
	 * @return
	 */
	private Integer generateId() {
		Set<Integer> ids = tickets.keySet();
		if (ids.isEmpty()) {
			return 1;
		}
		return Collections.max(ids) + 1;
	}
}
