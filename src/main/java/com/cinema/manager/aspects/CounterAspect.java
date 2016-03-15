package com.cinema.manager.aspects;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.cinema.manager.model.Event;
import com.cinema.manager.model.Ticket;
import com.cinema.manager.model.User;

@Aspect
public class CounterAspect {

	private Map<String, Integer>	eventNameCallCounters	= new HashMap<String, Integer>();

	// Contains eventId and number of Ticket.getPrice() calls
	private Map<Integer, Integer>	ticketPriceForEventCounters	= new HashMap<Integer, Integer>();

	// Contains eventId and number of bookings of its tickets
	private Map<Integer, Integer> eventTicketsBookingNumber = new HashMap<Integer, Integer>();

	public Map<String, Integer> getEventNameCallCounters() {
		return eventNameCallCounters;
	}

	public void setEventNameCallCounters(
			Map<String, Integer> eventNameCallCounters) {
		this.eventNameCallCounters = eventNameCallCounters;
	}

	public Map<Integer, Integer> getTicketPriceForEventCounters() {
		return ticketPriceForEventCounters;
	}

	public void setTicketPriceForEventCounters(
			Map<Integer, Integer> ticketPriceForEventCounters) {
		this.ticketPriceForEventCounters = ticketPriceForEventCounters;
	}

	public Map<Integer, Integer> getEventTicketsBookingNumber() {
		return eventTicketsBookingNumber;
	}

	public void setEventTicketsBookingNumber(
			Map<Integer, Integer> eventTicketsBookingNumber) {
		this.eventTicketsBookingNumber = eventTicketsBookingNumber;
	}

	@AfterReturning("getEventName() && getAllEventMethods()")
	public void getEventNameAdvice(JoinPoint joinPoint) {

		Object obj = joinPoint.getTarget();

		if (obj instanceof Event) {

			String eventName = ((Event) obj).getName();
			if (eventNameCallCounters.containsKey(eventName)) {
				eventNameCallCounters.put(eventName,
						eventNameCallCounters.get(eventName) + 1);
			} else {
				eventNameCallCounters.put(eventName, 1);
			}
		}
	}

	@AfterReturning("getPrice() && getAllTicketMethods()")
	public void getTicketPriceAdvice(JoinPoint joinPoint){
		Object obj = joinPoint.getTarget();

		if (obj instanceof Ticket)
		{
			Integer eventId = ((Ticket) obj).getEventId();
			if (ticketPriceForEventCounters.containsKey(eventId)) {
				ticketPriceForEventCounters.put(eventId,
						ticketPriceForEventCounters.get(eventId) + 1);
			} else {
				ticketPriceForEventCounters.put(eventId, 1);
			}
		}
	}

	// For the method public void bookTicket(User user, Ticket ticket) in BookingServiceImpl
	@AfterReturning("getAllBookingServiceImplMethods() && getBookTicket() && args(user, ticket)")
	public void bookingTicketAdvice(User user, Ticket ticket){
		Integer eventId = ticket.getEventId();
		if (eventTicketsBookingNumber.containsKey(eventId)){
			eventTicketsBookingNumber.put(eventId, eventTicketsBookingNumber.get(eventId) + 1);
		}
		else
		{
			eventTicketsBookingNumber.put(eventId, 1);
		}
	}

	// Pointcuts for the getEventNameAdvice
	@Pointcut("execution(* getName())")
	public void getEventName() {
	}

	@Pointcut("within(com.cinema.manager.model.Event)")
	public void getAllEventMethods() {
	}

	// Pointcuts for the getTicketPriceAdvice
	@Pointcut("execution(* getPrice())")
	public void getPrice(){
	}

	@Pointcut("within(com.cinema.manager.model.Ticket)")
	public void getAllTicketMethods() {
	}

	@Pointcut("within(com.cinema.manager.controller.service.BookingServiceImpl)")
	public void getAllBookingServiceImplMethods() {
	}

	@Pointcut("execution(* bookTicket(..))")
	public void getBookTicket() {
	}
}
