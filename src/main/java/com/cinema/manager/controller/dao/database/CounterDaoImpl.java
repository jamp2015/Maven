package com.cinema.manager.controller.dao.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.cinema.manager.controller.dao.CountersDao;

@Component
public class CounterDaoImpl extends DaoDB implements CountersDao {

	public boolean updateEventNameCallCounters(final Map<String, Integer>	eventNameCallCounters) {

		String sql = "INSERT INTO EventNameCallCounters(eventName, eventCount) VALUES(?, ?)";

		for (final Map.Entry<String, Integer> entry : eventNameCallCounters.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());

			getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

				public void setValues(final PreparedStatement ps, final int i) throws SQLException {
					ps.setString(1, entry.getKey());
					ps.setInt(2, entry.getValue());
				}

				public int getBatchSize() {
					return eventNameCallCounters.size();
				}
			});
		}
		return true;
	}

	public boolean updateTicketPriceForEventCounters(final Map<Integer, Integer>	ticketPriceForEventCounters) {

		String sql = "INSERT INTO EventTicketPriceCallsCounters(eventId, numberOfCalls) VALUES(?, ?)";

		for (final Map.Entry<Integer, Integer> entry : ticketPriceForEventCounters.entrySet()) {

			getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

				public void setValues(final PreparedStatement ps, final int i) throws SQLException {
					ps.setInt(1, entry.getKey());
					ps.setInt(2, entry.getValue());
				}

				public int getBatchSize() {
					return 1;
				}
			});
		}
		return true;
	}

	public boolean updateEventTicketsBookingNumber(final Map<Integer, Integer>	eventTicketsBookingNumber) {
		String sql = "INSERT INTO EventTicketsBookingCounters(eventId, numberOfCalls) VALUES(?, ?)";

		for (final Map.Entry<Integer, Integer> entry : eventTicketsBookingNumber.entrySet()) {

			getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

				public void setValues(final PreparedStatement ps, final int i) throws SQLException {
					ps.setInt(1, entry.getKey());
					ps.setInt(2, entry.getValue());
				}

				public int getBatchSize() {
					return 1;
				}
			});
		}
		return true;
	}

}
