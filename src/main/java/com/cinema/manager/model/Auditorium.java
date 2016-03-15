package com.cinema.manager.model;

public class Auditorium {

	private int	   id;
	private String	name;
	private int	   numberOfSeats;
	private String	vipSeats;

	public Auditorium() {
	}

	public Auditorium(int id, String name, int numberOfSeats, String vipSeats) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfSeats = numberOfSeats;
		this.vipSeats = vipSeats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getVipSeats() {
		return vipSeats;
	}

	public void setVipSeats(String vipSeats) {
		this.vipSeats = vipSeats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberOfSeats;
		result = prime * result
				+ ((vipSeats == null) ? 0 : vipSeats.hashCode());
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
		Auditorium other = (Auditorium) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfSeats != other.numberOfSeats)
			return false;
		if (vipSeats == null) {
			if (other.vipSeats != null)
				return false;
		} else if (!vipSeats.equals(other.vipSeats))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Auditorium [id=" + id + ", name=" + name + ", numberOfSeats="
				+ numberOfSeats + ", vipSeats=" + vipSeats + "]";
	}
}
