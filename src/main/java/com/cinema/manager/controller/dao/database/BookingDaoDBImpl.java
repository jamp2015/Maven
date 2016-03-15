package com.cinema.manager.controller.dao.database;

import java.sql.Types;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cinema.manager.controller.dao.BookingDao;
import com.cinema.manager.model.Booking;
import com.cinema.manager.model.Ticket;

@Component
public class BookingDaoDBImpl extends DaoDB implements BookingDao {

	public boolean create(int userId, List<Ticket> tickets) {
		return false;
	}

	public boolean delete(int id) {
		// Delete from Booking
		String sql = "DELETE FROM Booking WHERE Id=?";
		// Define query arguments
		Object[] params = {id};

		// Define SQL types of the arguments
		int[] types = {Types.BIGINT};

		getJdbcTemplate().update(sql, params, types);

		// Delete form BookingContent
		sql = "DELETE FROM BookingContent WHERE bookingId=?";

		getJdbcTemplate().update(sql, params, types);

		return true;
	}

	public boolean update(int id, int userId, List<Ticket> tickets) {
		// TODO Auto-generated method stub
		return false;
	}

	public Booking getBooking(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Booking> getAllBookings() {
		String sql = "";
		return null;
	}

	/*	private static final class BookingMapper implements RowMapper<Booking>{
		public Auditorium mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int numberOfSeats = resultSet.getInt("numberOfSeats");
			String vipSeats = resultSet.getString("vipSeats");

			return new Auditorium(id, name, numberOfSeats, vipSeats);
		}
	}*/

}
