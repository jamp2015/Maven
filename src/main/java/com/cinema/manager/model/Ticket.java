package com.cinema.manager.model;

public class Ticket {

	private int	   id;
	private int	   eventId;
	private String	seats;
	private int	   price;

	public Ticket(String id, String eventId, String seats, String price) {
		this.id = Integer.parseInt(id);
		this.eventId = Integer.parseInt(eventId);
		this.seats = seats;
		this.price = Integer.parseInt(price);
	}

	public Ticket(int id, int eventId, String seats, int price) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.seats = seats;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventId;
		result = prime * result + id;
		result = prime * result + price;
		result = prime * result + ((seats == null) ? 0 : seats.hashCode());
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
		Ticket other = (Ticket) obj;
		if (eventId != other.eventId)
			return false;
		if (id != other.id)
			return false;
		if (price != other.price)
			return false;
		if (seats == null) {
			if (other.seats != null)
				return false;
		} else if (!seats.equals(other.seats))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", eventId=" + eventId + ", seats=" + seats
				+ ", price=" + price + "]";
	}

}
