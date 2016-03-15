package com.cinema.aop.examples.kou.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.cinema.aop.examples.kou.model.User;

@Aspect
public class UserAspect {

	@AfterReturning("args(user)")
	public void onSetUser(User user){
		System.out.println("User : " + user.getName());
	}

	@Pointcut("args(user)")
	public void setUser(){
	}
}
