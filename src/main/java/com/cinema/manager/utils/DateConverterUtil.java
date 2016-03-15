package com.cinema.manager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverterUtil {

	private static final String	SIMPLE_DATE_FORMAT	= "yyyy-MM-dd HH:mm:ss.S";

	public static Date getSimpleDate(String date) throws ParseException {
		return new SimpleDateFormat(SIMPLE_DATE_FORMAT).parse(date);
	}

	public static String dateToString(Date date) {
		return new SimpleDateFormat(SIMPLE_DATE_FORMAT).format(date);
	}

}
