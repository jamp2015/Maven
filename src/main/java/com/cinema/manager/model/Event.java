package com.cinema.manager.model;

import java.text.ParseException;
import java.util.Date;

import com.cinema.manager.utils.DateConverterUtil;

/**
 * Describes an event (movie).
 *
 * @author Admin
 *
 */
public class Event {

	private int	    id;
	private String	name;
	private Date	date;
	private Ratings	rating;
	private int	    auditoriumId;

	public Event(int id, String name, Date date, Ratings rating,
			int auditoriumId) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.rating = rating;
		this.auditoriumId = auditoriumId;
	}

	public Event(String id, String name, String date, String rating, String auditoriumId) throws ParseException {
		this.id = Integer.parseInt(id);
		this.name = name;
		this.date = DateConverterUtil.getSimpleDate(date);
		this.rating = Ratings.valueOf(rating);
		this.auditoriumId = Integer.parseInt(auditoriumId);
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Ratings getRating() {
		return rating;
	}

	public void setRating(Ratings rating) {
		this.rating = rating;
	}

	public int getAuditoriumId() {
		return auditoriumId;
	}

	public void setAuditoriumId(int auditoriumId) {
		this.auditoriumId = auditoriumId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + auditoriumId;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
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
		Event other = (Event) obj;
		if (auditoriumId != other.auditoriumId)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", date=" + date
				+ ", rating=" + rating + ", auditoriumId=" + auditoriumId + "]";
	}

}
