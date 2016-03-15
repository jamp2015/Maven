package com.cinema.manager;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cinema.manager.controller.dao.BookingDao;
import com.cinema.manager.demo.Demo;

/**
 * Main application. Runs all demos.
 *
 * @author Igor_Shingaryov
 *
 */
public class App {

	List<Demo>	demoList;

	public App(List<Demo> demoList) {
		super();
		this.demoList = demoList;
	}

	public List<Demo> getDemoList() {
		return demoList;
	}

	public void setDemoList(List<Demo> demoList) {
		this.demoList = demoList;
	}

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");

		App application = (App) context.getBean("application");

		for (Demo demo : application.getDemoList()) {
			demo.execute();
		}

		// Test dao for database
		/*		AuditoriumDao auditoriumDao = (AuditoriumDao) context.getBean("auditoriumDaoDBImpl");
		System.out.println(auditoriumDao.getAuditoriums());

		//auditoriumDao.create("Rocket", 400, "1 - 20");

		System.out.println(auditoriumDao.getAuditorium(5));
		auditoriumDao.delete(4);
		System.out.println(auditoriumDao.getAuditoriums());

		Auditorium auditorium = auditoriumDao.getAuditorium(5);
		auditorium.setName("Cinema");
		auditoriumDao.update(0, auditorium);
		System.out.println(auditoriumDao.getAuditoriums());*/

		/*		EventDao eventDao = (EventDao) context.getBean("eventDaoDBImpl");

		System.out.println(eventDao.getEvent(1));

		// eventDao.create("Titanic", new Date(), Ratings.HIGH, 2);

		Event event = new Event(0, "Titanic", new Date(), Ratings.HIGH, 3);
		eventDao.update(3, event);

		System.out.println(eventDao.getByName("Titanic"));
		eventDao.bookEventAuditorium(1, 3);*/

		BookingDao bookingDao = (BookingDao) context.getBean("bookingDaoDBImpl");
		bookingDao.delete(1);

		context.close();
	}
}
