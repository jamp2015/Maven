package com.cinema.aop.examples.kou.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.cinema.manager.model.Event;

@Aspect
public class CounterAspect {

	private Map<String, Integer>	eventNameCallCounters	= new HashMap<String, Integer>();

	public Map<String, Integer> getEventNameCallCounters() {
		return eventNameCallCounters;
	}

	public void setEventNameCallCounters(
			Map<String, Integer> eventNameCallCounters) {
		this.eventNameCallCounters = eventNameCallCounters;
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

	/*	@AfterReturning("getPrice()")
	public void getTicketPriceAdvice(JoinPoint joinPoint){

	}*/

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

}
