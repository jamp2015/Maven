package com.cinema.manager.controller.service.logic;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cinema.manager.model.Ticket;
import com.cinema.manager.model.User;


public class BirthdayStrategy implements DiscountStrategy {

	public int discount(User user, List<Ticket> tickets) {

		Date today = new Date();
		double totalDiscount = 0.0;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);

		int todayMonth = calendar.get(Calendar.MONTH);
		int todayDay = calendar.get(Calendar.DAY_OF_MONTH);

		Date userDateOfBirth = user.getDateOfBirth();
		calendar.setTime(userDateOfBirth);

		int userDateOfBirthMonth = calendar.get(Calendar.MONTH);
		int userDateOfBirthDay = calendar.get(Calendar.DAY_OF_MONTH);

		if ((todayMonth == userDateOfBirthMonth) && (todayDay == userDateOfBirthDay))
		{
			for (Ticket ticket : tickets){
				totalDiscount += 0.05*ticket.getPrice();
			}
		}
		return (int) totalDiscount;
	}
}