package com.cinema.manager.controller.dao;

import java.util.List;

import com.cinema.manager.model.Ticket;

public interface TicketDao {

	boolean create(int eventId, String seats, int price);

	boolean delete(int id);

	boolean update(int id, int eventId, String seats, int price);

	Ticket getTicket(int id);

	List<Ticket> getAllTickets();
}
