package com.cinema.manager.controller.dao.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.cinema.manager.controller.dao.AuditoriumDao;
import com.cinema.manager.model.Auditorium;

@Component
public class AuditoriumDaoDBImpl extends DaoDB implements AuditoriumDao {

	public boolean create(String name, int numberOfSeats, String vipSeats) {
		String sql = "INSERT INTO Auditoriums(name, numberOfSeats, vipSeats) VALUES(:name, :numberOfSeats, :vipSeats)";
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("name", name);
		mapSqlParameterSource.addValue("numberOfSeats", numberOfSeats);
		mapSqlParameterSource.addValue("vipSeats", vipSeats);

		getNamedParameterJdbcTemplate().update(sql, mapSqlParameterSource);
		return true;
	}

	public boolean delete(int id) {
		String sql = "DELETE FROM Auditoriums WHERE Id=?";
		// Define query arguments
		Object[] params = {id};

		// Define SQL types of the arguments
		int[] types = {Types.BIGINT};

		getJdbcTemplate().update(sql, params, types);
		return true;
	}

	public boolean update(int id, Auditorium auditorium) {
		String sql = "UPDATE Auditoriums SET name=?, numberOfSeats=?, vipSeats=? WHERE Id=?";

		// Define query arguments
		Object[] params = {auditorium.getName(), auditorium.getNumberOfSeats(), auditorium.getVipSeats(), id};

		// Define SQL types of the arguments
		int[] types = {Types.VARCHAR, Types.BIGINT, Types.VARCHAR, Types.BIGINT};

		getJdbcTemplate().update(sql, params, types);
		return true;
	}

	public Auditorium getAuditorium(Integer id) {
		String sql = "SELECT * FROM Auditoriums WHERE Id=?";
		return getJdbcTemplate().queryForObject(sql, new Object[] {id}, new AuditoriumMapper());
	}

	public List<Auditorium> getAuditoriums() {
		String sql = "SELECT * FROM Auditoriums";
		return getJdbcTemplate().query(sql, new AuditoriumMapper());
	}

	private static final class AuditoriumMapper implements RowMapper<Auditorium>{
		public Auditorium mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int numberOfSeats = resultSet.getInt("numberOfSeats");
			String vipSeats = resultSet.getString("vipSeats");

			return new Auditorium(id, name, numberOfSeats, vipSeats);
		}
	}
}
