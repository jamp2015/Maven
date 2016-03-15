package com.cinema.manager.demo;

import com.cinema.manager.controller.Controller;
import com.cinema.manager.controller.service.AuditoriumService;
import com.cinema.manager.model.Auditorium;

public class AuditoriumServiceDemo implements Demo {

	private Controller controller;

	public AuditoriumServiceDemo(Controller controller) {
		super();
		this.controller = controller;
	}

	public void execute() {
		System.out.println();
		System.out.println("************* AUDITORIUM SERVICE DEMO ****************");
		AuditoriumService auditoriumService = controller.getAuditoriumService();

		System.out.println("All auditoriums after create:");
		auditoriumService.create("Palace", 300, "2,3,4,5");
		System.out.println(auditoriumService.getAuditoriums());

		System.out.println("All auditoriums after delete auditorium id = 2:");
		auditoriumService.delete(2);
		System.out.println(auditoriumService.getAuditoriums());

		System.out.println("All auditoriums after update:");
		Auditorium auditorium = new Auditorium(0, "Leo", 100, "1,2,3,4,5");
		auditoriumService.update(3, auditorium);

		System.out.println(auditoriumService.getAuditorium(3));
		System.out.println(auditoriumService.getAuditoriums());
		System.out.println();
	}

}
