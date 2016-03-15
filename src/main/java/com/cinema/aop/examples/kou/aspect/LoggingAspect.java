package com.cinema.aop.examples.kou.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Before("allGetters() && allCircleMethods()")
	public void loggingAdvice(JoinPoint joinpoint) {
		System.out.println("Running logging aspect. Get method called");
		System.out.println(joinpoint.getTarget().getClass().getSimpleName());
	}

	// @Before("allGetters()")
	public void secondAdvice() {
		System.out.println("Running second aspect. Get method called");
	}

	/*
	 * @AfterReturning(pointcut = "args(name)", returning = "returnString")
	 * public void afterReturningAdvice() { System.out
	 * .println("A method that takes String arguments has been called"); }
	 */
	// @Before("stringArgumentMethods()")
	@Before("args(name)")
	public void logStringArgumentMethods(String name) {
		System.out
		        .println("Running log string argument methods name = " + name);
	}

	@Pointcut("execution(* get*(..))")
	public void allGetters() {
	}

	@Pointcut("within(com.cinema.aop.examples.kou.model.Circle)")
	public void allCircleMethods() {
	}

	/*
	 * @Pointcut("args(name)") public void stringArgumentMethods() { }
	 */

}
