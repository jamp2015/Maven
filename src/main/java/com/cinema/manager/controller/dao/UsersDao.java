package com.cinema.manager.controller.dao;

import java.util.Date;
import java.util.List;

import com.cinema.manager.model.User;

public interface UsersDao {

	List<User> getAllUsers();

	List<User> getUsersByName(String name);

	/**
	 * Gets a user by Email
	 *
	 * @param email
	 * @return
	 */
	public User getUserByEmail(String email);

	boolean create(String name, String email, Date dateOfBirth);

	User getUser(Integer id);

	boolean delete(Integer id);

	boolean update(User user);
}
