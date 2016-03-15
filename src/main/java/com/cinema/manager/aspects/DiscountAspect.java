package com.cinema.manager.aspects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.cinema.manager.model.Ticket;
import com.cinema.manager.model.User;

@Aspect
public class DiscountAspect {

	private Map<String, Integer> discountsCounters = new HashMap<String, Integer>();
	private Map<Integer, Map<String, Integer>> discountsForUser = new HashMap<Integer, Map<String, Integer>>();

	// Count how many times each discount was given
	@AfterReturning("getDiscount() && getAllStrategyMethods())")
	public void countDiscountsCalls(JoinPoint joinPoint){
		Object obj = joinPoint.getTarget();

		String simpleClassName = obj.getClass().getSimpleName();
		if (discountsCounters.containsKey(simpleClassName)){
			discountsCounters.put(simpleClassName, discountsCounters.get(simpleClassName) + 1);
		}
		else
		{
			discountsCounters.put(simpleClassName, 1);
		}
	}

	// Count how many times each discount was given for a specific user
	@AfterReturning("(getDiscount() && getAllStrategyMethods()) && args(user, ticketList)")
	public void countDiscountsForUser(JoinPoint joinPoint, User user, List<Ticket> ticketList){

		int userId = user.getId();

		if (!discountsForUser.containsKey(userId))
		{
			discountsForUser.put(userId, new HashMap<String, Integer>());
		}

		// Count how many times each discount was given for a user
		Map<String, Integer> discountsCounters = discountsForUser.get(userId);

		Object obj = joinPoint.getTarget();

		String simpleClassName = obj.getClass().getSimpleName();
		if (discountsCounters.containsKey(simpleClassName)){
			discountsCounters.put(simpleClassName, discountsCounters.get(simpleClassName) + 1);
		}
		else
		{
			discountsCounters.put(simpleClassName, 1);
		}
	}

	public Map<Integer, Map<String, Integer>> getDiscountsForUser() {
		return discountsForUser;
	}

	public void setDiscountsForUser(
			Map<Integer, Map<String, Integer>> discountsForUser) {
		this.discountsForUser = discountsForUser;
	}

	public Map<String, Integer> getDiscountsCounters() {
		return discountsCounters;
	}

	public void setDiscountsCounters(Map<String, Integer> discountsCounters) {
		this.discountsCounters = discountsCounters;
	}

	@Pointcut("execution(* discount(..))")
	public void getDiscount(){
	}

	@Pointcut("within(com.cinema.manager.controller.service.logic.*)")
	public void getAllStrategyMethods(){
	}
}
