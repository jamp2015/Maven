package com.cinema.manager.controller.dao.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.cinema.manager.controller.dao.EventDao;
import com.cinema.manager.model.Event;
import com.cinema.manager.model.Ratings;

@Component
public class EventDaoDBImpl extends DaoDB implements EventDao {

	public boolean create(String name, Date date, Ratings rating,
			int auditoriumId) {

		String sql = "INSERT INTO CinemaEvents(name, eventDate, rating, auditoriumId) "
				+ "VALUES(:name, :eventDate, :rating, :auditoriumId)";

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("name", name);
		mapSqlParameterSource.addValue("eventDate", date);
		mapSqlParameterSource.addValue("rating", rating.toString());
		mapSqlParameterSource.addValue("auditoriumId", auditoriumId);

		getNamedParameterJdbcTemplate().update(sql, mapSqlParameterSource);
		return true;
	}

	public boolean update(int id, Event event) {
		String sql = "UPDATE CinemaEvents SET name=?, eventDate=?, rating=?, auditoriumId=? WHERE Id=?";

		// Define query arguments
		Object[] params = {event.getName(), event.getDate(), event.getRating().toString(), event.getAuditoriumId(), id};

		// Define SQL types of the arguments
		int[] types = {Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT, Types.BIGINT};

		getJdbcTemplate().update(sql, params, types);
		return false;
	}

	public boolean delete(int id) {
		String sql = "DELETE FROM CinemaEvents WHERE Id=?";
		// Define query arguments
		Object[] params = {id};

		// Define SQL types of the arguments
		int[] types = {Types.BIGINT};

		getJdbcTemplate().update(sql, params, types);
		return true;
	}

	public Event getEvent(int id) {
		String sql = "SELECT * FROM CinemaEvents WHERE Id=?";
		return getJdbcTemplate().queryForObject(sql, new Object[] {id}, new EventMapper());
	}

	public List<Event> getByName(String name) {
		String sql = "SELECT * FROM CinemaEvents WHERE name=?";
		return getJdbcTemplate().query(sql, new Object[] {name}, new EventMapper());
	}

	public List<Event> getAllEvents() {
		String sql = "SELECT * FROM CinemaEvents";
		return getJdbcTemplate().query(sql, new EventMapper());
	}

	public boolean bookEventAuditorium(Integer eventId, int auditoriumId) {

		String sql = "INSERT INTO CinemaEventsBookingAuditorium(eventId, auditoriumId) "
				+ "VALUES(:eventId, :auditoriumId)";

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("eventId", eventId);
		mapSqlParameterSource.addValue("auditoriumId", auditoriumId);

		getNamedParameterJdbcTemplate().update(sql, mapSqlParameterSource);
		return true;
	}

	private static final class EventMapper implements RowMapper<Event>{
		public Event mapRow(ResultSet resultSet, int rowNum) throws SQLException {

			int	    id = resultSet.getInt("id");
			String	name = resultSet.getString("name");
			Timestamp	date = resultSet.getTimestamp("eventDate");
			Ratings	rating = Ratings.valueOf(resultSet.getString("rating"));
			int	    auditoriumId = resultSet.getInt("auditoriumId");;

			return new Event(id, name, date, rating, auditoriumId);
		}
	}
}
