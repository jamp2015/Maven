package com.cinema.manager.tests;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.cinema.manager.utils.DateConverterUtil;

public class DateConverterUtilTest {

	@Test
	public void getSimpleDateTest() throws ParseException {
		String dateStr = "1987-11-18 00:00:00.0";
		Date date = DateConverterUtil.getSimpleDate(dateStr);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		assertEquals(1987, calendar.get(Calendar.YEAR));
		assertEquals(10, calendar.get(Calendar.MONTH));
		assertEquals(18, calendar.get(Calendar.DAY_OF_MONTH));
	}

	@Test
	public void dateToString() {

		String example = "1987-11-18 00:00:00.0";
		Calendar calendar = Calendar.getInstance();

		calendar.clear();
		calendar.set(1987, 10, 18, 0, 0, 0);
		Date date = calendar.getTime();

		String dateStr = DateConverterUtil.dateToString(date);
		assertEquals(example, dateStr);
	}
}
