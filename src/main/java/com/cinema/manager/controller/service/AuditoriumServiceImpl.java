package com.cinema.manager.controller.service;

import java.util.List;

import com.cinema.manager.controller.dao.AuditoriumDao;
import com.cinema.manager.model.Auditorium;

public class AuditoriumServiceImpl implements AuditoriumService {

	private AuditoriumDao	auditoriumDao;

	public AuditoriumServiceImpl(AuditoriumDao auditoriumDao) {
		this.auditoriumDao = auditoriumDao;
	}

	public boolean create(String name, int numberOfSeats, String vipSeats) {
		return auditoriumDao.create(name, numberOfSeats, vipSeats);
	}

	public boolean delete(int id) {
		return auditoriumDao.delete(id);
	}

	public boolean update(int id, Auditorium auditorium) {
		return auditoriumDao.update(id, auditorium);
	}

	public Auditorium getAuditorium(Integer id) {
		return auditoriumDao.getAuditorium(id);
	}

	public List<Auditorium> getAuditoriums() {
		return auditoriumDao.getAuditoriums();
	}
}
