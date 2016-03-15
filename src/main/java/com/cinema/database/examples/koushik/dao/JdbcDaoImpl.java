package com.cinema.database.examples.koushik.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.cinema.database.examples.koushik.model.Circle;

@Component
public class JdbcDaoImpl {

	private Connection	      connect;
	private Statement	      statement;
	private PreparedStatement	preparedStatement;
	private ResultSet	      resultSet;

	private JdbcTemplate	  jdbcTemplate	= new JdbcTemplate();
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


	public Circle getCircle(int circleId) {

		Circle circle = null;
		try {
			// Setup the connection with the DB
			connect = jdbcTemplate.getDataSource().getConnection();

			preparedStatement = connect
					.prepareStatement("SELECT * FROM figures.figures WHERE id = ?");

			// Initialize the parameter value
			preparedStatement.setInt(1, circleId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				circle = new Circle(circleId, resultSet.getString("name"));
			}

		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
			close();
		}

		return circle;
	}

	/**
	 * Returns a number circles.
	 *
	 * @return
	 */
	public int getCircleCount() {
		String sql = "SELECT Count(*) FROM Figures";
		// jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}


	public String getCircleNameById(int circleId){
		String sql = "SELECT NAME FROM Figures WHERE Id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, String.class);
	}

	/**
	 * Extracts a circle by its Id.
	 * @param circleId
	 * @return
	 */
	public Circle getCircleById(int circleId){
		String sql = "SELECT * FROM Figures WHERE Id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, new CircleMapper());
	}

	public List<Circle> getAllCircles(){
		String sql = "SELECT * FROM Figures";
		return jdbcTemplate.query(sql, new CircleMapper());
	}

	/*	public void insertCircle(Circle circle){
		String sql = "INSERT INTO Figures(Id, NAME) VALUES(?, ?)";
		jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});
	}*/

	public void insertCircle(Circle circle){
		String sql = "INSERT INTO Figures(Id, NAME) VALUES(:id, :name)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId()).addValue("name", circle.getName());

		namedParameterJdbcTemplate.update(sql, namedParameters);
	}

	public void  createPlainFiguresTable(){
		String sql = "CREATE TABLE plainFigures (id INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(50) NOT NULL, PRIMARY KEY (ID));";
		jdbcTemplate.execute(sql);
	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {

		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			String id = resultSet.getString("id");
			String name = resultSet.getString("name");

			System.out.println("Id: " + id);
			System.out.println("Name: " + name);
		}
	}

	// You need to close the resultSet
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
		}
	}

	public DataSource getDataSource() {
		return jdbcTemplate.getDataSource();
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	/**
	 * Returns an object extracted from the DB.
	 * @author Igor_Shingaryov
	 *
	 */
	private static final class CircleMapper implements RowMapper<Circle> {

		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(resultSet.getInt("Id"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}
	}
}
