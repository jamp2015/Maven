package com.cinema.manager.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {

	public static String generateRandomString(int length) {
		return RandomStringUtils.random(length);
	}
}
