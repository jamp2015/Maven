package com.cinema.database.examples.koushik.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cinema.database.examples.koushik.model.Circle;

public class JdbcDaoImpl2 {

	private Connection	      connect;
	private Statement	      statement;
	private PreparedStatement	preparedStatement;
	private ResultSet	      resultSet;

	private String	          driver	= "jdbc:mysql";
	private String	          server	= "localhost";
	private String	          dataBase	= "figures";
	private String	          user	   = "Admin";
	private String	          password	= "1111";

	public Circle getCircle(int circleId) {

		Circle circle = null;
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			String url = driver + "://" + server + "/" + dataBase + "?user="
					+ user + "&password=" + password;

			// Setup the connection with the DB
			connect = DriverManager.getConnection(url);

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
}
