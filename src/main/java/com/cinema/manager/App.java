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

		context.close();
	}
}
