package com.cinema.manager.model;

import java.util.List;

/**
 * Describes all tickets booked by a user
 *
 * @author Admin
 *
 */
public class Booking {

	private int	         id;
	private int	         userId;
	private List<Ticket>	tickets;

	public Booking(int id, int userId, List<Ticket> tickets) {
		super();
		this.id = id;
		this.userId = userId;
		this.tickets = tickets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", userId=" + userId + ", tickets="
				+ tickets + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (id != other.id)
			return false;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

}
