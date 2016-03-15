package com.cinema.manager.controller.service;

import java.util.List;

import com.cinema.manager.model.Auditorium;

public interface AuditoriumService {

	boolean create(String name, int numberOfSeats, String vipSeats);

	boolean delete(int id);

	boolean update(int id, Auditorium auditorium);

	Auditorium getAuditorium(Integer id);

	List<Auditorium> getAuditoriums();
}
