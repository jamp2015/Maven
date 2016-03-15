package com.cinema.manager.controller.service;

import java.util.List;

import com.cinema.manager.controller.service.logic.DiscountStrategy;
import com.cinema.manager.model.Ticket;
import com.cinema.manager.model.User;

public class DiscountServiceImpl implements DiscountService {

	private List<DiscountStrategy>	discountStrategy;

	public DiscountServiceImpl(List<DiscountStrategy> discountStrategy) {
		this.discountStrategy = discountStrategy;
	}

	public int getDiscount(User user, List<Ticket> ticketList) {

		int totalDiscount = 0;

		for (DiscountStrategy strategy : discountStrategy)
		{
			totalDiscount += strategy.discount(user, ticketList);
		}
		return totalDiscount;
	}

}
