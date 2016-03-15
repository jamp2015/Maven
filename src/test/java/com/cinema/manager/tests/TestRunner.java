package com.cinema.manager.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		// Run JUnit tests
		System.out.println("Run tests");

		Result result = JUnitCore.runClasses(UserServiceTest.class,
		        AuditoriumDaoTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("Result successful: " + result.wasSuccessful());
	}
}
