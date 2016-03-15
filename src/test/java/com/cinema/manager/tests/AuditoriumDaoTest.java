package com.cinema.manager.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AuditoriumDaoTest {

	private static ConfigurableApplicationContext	context;

	@BeforeClass
	public static void setUp() {
		context = new ClassPathXmlApplicationContext("spring.xml");
	}

	@Test
	public void auditoriumDaoTest() {
		/*
		 * AuditoriumDao auditoriumDao = (AuditoriumDao) context
		 * .getBean("auditoriumDao");
		 * 
		 * assertEquals("Victory", auditoriumDao.getAuditorium(1).getName());
		 * assertEquals(100, auditoriumDao.getAuditorium(1).getNumberOfSeats());
		 * assertEquals("1,2,3,4,5,6,7,8,9,10", auditoriumDao.getAuditorium(1)
		 * .getVipSeats());
		 * 
		 * assertEquals("Ultimate Palace", auditoriumDao.getAuditorium(2)
		 * .getName()); assertEquals("Rodgers Theatre",
		 * auditoriumDao.getAuditorium(3) .getName()); assertEquals("Odeon",
		 * auditoriumDao.getAuditorium(4).getName());
		 * 
		 * context.close();
		 */
	}
}
