package com.cinema.manager.controller.dao.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.cinema.manager.controller.dao.AuditoriumDao;
import com.cinema.manager.model.Auditorium;

public class AuditoriumDaoImpl implements AuditoriumDao {

	// Hold auditorium info. Injected by Spring
	private Map<Integer, Auditorium>	auditoriums	= new HashMap<Integer, Auditorium>();

	/**
	 * Constructor.
	 *
	 * @param auditoriumProps
	 *            properties
	 * @throws Exception
	 */
	public AuditoriumDaoImpl(List<Properties> auditoriumProps) throws Exception {

		// Fill the map with auditoriums.
		for (Properties props : auditoriumProps) {
			Integer id = Integer.parseInt(props.getProperty("id"));
			String name = props.getProperty("name");
			int numberOfSeats = Integer
					.parseInt(props.getProperty("numberOfSeats"));
			String vipSeats = props.getProperty("vipSeats");

			// String id = generateAuditoriumId();
			Auditorium auditorium = new Auditorium(id, name, numberOfSeats,
					vipSeats);
			auditoriums.put(id, auditorium);
		}
	}

	public List<Auditorium> getAuditoriums() {
		List<Auditorium> items = new ArrayList<Auditorium>();
		items.addAll(auditoriums.values());
		return items;
	}

	public void setAuditoriums(Map<Integer, Auditorium> auditoriums) {
		this.auditoriums = auditoriums;
	}

	public Auditorium getAuditorium(Integer id) {
		return auditoriums.get(id);
	}

	public boolean create(String name, int numberOfSeats, String vipSeats) {
		Integer id = generateId();
		Auditorium auditorium = new Auditorium(id, name, numberOfSeats,
				vipSeats);
		auditoriums.put(id, auditorium);
		return true;
	}

	public boolean delete(int id) {
		Auditorium auditorium = auditoriums.remove(id);
		if (auditorium != null) {
			return true;
		}
		return false;
	}

	public boolean update(int id, Auditorium auditorium) {
		Auditorium updatedAuditorium = auditoriums.put(id, auditorium);
		if (updatedAuditorium != null) {
			return true;
		}
		return false;
	}

	/**
	 * Generates an id for an event.
	 *
	 * @return
	 */
	private Integer generateId() {
		Set<Integer> ids = auditoriums.keySet();
		if (ids.isEmpty()) {
			return 1;
		}
		return Collections.max(ids) + 1;
	}
}
