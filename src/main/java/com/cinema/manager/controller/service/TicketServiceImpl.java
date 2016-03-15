package com.cinema.manager.controller.service;

import java.util.List;

import com.cinema.manager.controller.dao.TicketDao;
import com.cinema.manager.model.Ticket;

public class TicketServiceImpl implements TicketService {

	private TicketDao ticketDao;

	public TicketServiceImpl(TicketDao ticketDao) {
		super();
		this.ticketDao = ticketDao;
	}

	public boolean create(int eventId, String seats, int price){
		return ticketDao.create(eventId, seats, price);
	};

	public boolean delete(int id){
		return ticketDao.delete(id);
	};

	public boolean update(int id, int eventId, String seats, int price){
		return ticketDao.update(id, eventId, seats, price);
	};

	public Ticket getTicket(int id){
		return ticketDao.getTicket(id);
	};

	public List<Ticket> getAllTickets(){
		return ticketDao.getAllTickets();
	};
}
