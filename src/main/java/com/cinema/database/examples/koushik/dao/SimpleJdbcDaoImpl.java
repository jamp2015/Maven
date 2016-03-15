package com.cinema.database.examples.koushik.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

@Component
public class SimpleJdbcDaoImpl extends SimpleJdbcCall {

	public SimpleJdbcDaoImpl(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
	}

	/**
	 * Returns a number circles.
	 *
	 * @return
	 */
	public int getCircleCount() {
		String sql = "SELECT Count(*) FROM Figures";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

}
