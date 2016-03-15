package com.cinema.aop.examples.writer;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageDecorator implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Start method invocation.");
		Object retVal = invocation.proceed();
		System.out.println("End method invocation.");
		return null;
	}
}
