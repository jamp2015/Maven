package com.cinema.manager.controller.service.logic;

import java.util.List;

import com.cinema.manager.model.Ticket;
import com.cinema.manager.model.User;

public interface DiscountStrategy {

	int discount(User user, List<Ticket> tickets);
}
