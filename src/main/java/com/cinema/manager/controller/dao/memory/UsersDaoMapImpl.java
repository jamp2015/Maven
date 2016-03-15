package com.cinema.manager.controller.dao.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.cinema.manager.controller.dao.UsersDao;
import com.cinema.manager.model.User;
import com.cinema.manager.utils.DateConverterUtil;

public class UsersDaoMapImpl implements UsersDao {

	// Hold users info. Injected by Spring
	private Map<Integer, User>	users	= new HashMap<Integer, User>();

	/**
	 * Constructor.
	 *
	 * @param auditoriumProps
	 *            properties
	 * @throws Exception
	 */
	public UsersDaoMapImpl(List<Properties> userProps) throws Exception {

		// Fill the map with auditoriums.
		for (Properties props : userProps) {
			Integer id = Integer.parseInt(props.getProperty("id"));
			String name = props.getProperty("name");
			String email = props.getProperty("email");
			Date dateOfBirth = DateConverterUtil.getSimpleDate(props
					.getProperty("dateOfBirth"));

			User user = new User(id, name, email, dateOfBirth);
			users.put(id, user);
		}
	}

	public List<User> getAllUsers() {
		if (users == null) {
			return null;
		}
		List<User> userList = new ArrayList<User>();
		userList.addAll(users.values());
		return userList;
	}

	public List<User> getUsersByName(String name) {
		if (users != null && name != null) {
			User user;
			List<User> userList = new ArrayList<User>();
			for (Map.Entry<Integer, User> entry : users.entrySet()) {
				user = entry.getValue();
				if (name.equals(user.getName())) {
					userList.add(user);
				}
			}
			return userList;
		}
		return null;
	}

	public User getUserByEmail(String email) {
		if (users != null && email != null) {
			User user;
			for (Map.Entry<Integer, User> entry : users.entrySet()) {
				user = entry.getValue();
				if (email.equals(user.getEmail())) {
					return user;
				}
			}
		}
		return null;
	}

	public boolean create(String name, String email, Date dateOfBirth) {
		Integer id = generateId();
		User user = new User(id, name, email, dateOfBirth);
		users.put(id, user);
		return true;
	}

	public User getUser(Integer id) {
		if (users != null) {
			return users.get(id);
		}
		return null;
	}

	public boolean delete(Integer id) {
		if (users.remove(id) != null) {
			return true;
		}
		return false;
	}

	public boolean update(User user) {
		if (users != null) {
			users.put(user.getId(), user);
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
		Set<Integer> ids = users.keySet();
		if (ids.isEmpty()) {
			return 1;
		}
		return Collections.max(ids) + 1;
	}

}
