package com.cinema.manager.controller.service;

import java.util.Date;
import java.util.List;

import com.cinema.manager.controller.dao.UsersDao;
import com.cinema.manager.model.User;

public class UserServiceImpl implements UserService {

	private UsersDao	usersDao;

	public UserServiceImpl(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public List<User> getAllUsers() {
		return usersDao.getAllUsers();
	}

	public List<User> getUsersByName(String name) {
		return usersDao.getUsersByName(name);
	}

	public User getUserByEmail(String email) {
		return usersDao.getUserByEmail(email);
	}

	public boolean create(String name, String email, Date dateOfBirth) {
		return usersDao.create(name, email, dateOfBirth);
	}

	public User getUser(Integer id) {
		return usersDao.getUser(id);
	}

	public boolean delete(Integer id) {
		return usersDao.delete(id);
	}

	public boolean update(User user) {
		return usersDao.update(user);
	}
}
