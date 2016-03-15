package com.cinema.aop.examples.writer;

import org.springframework.aop.framework.ProxyFactory;

public class AOPExample {

	public static void main(String[] args) {
		MessageWriter target = new MessageWriter();

		// Create the proxy
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new MessageDecorator());
		pf.setTarget(target);
		MessageWriter proxy = (MessageWriter) pf.getProxy();

		// Write the messages target.writeMessage();
		target.writeMessage();

		System.out.println("");
		proxy.writeMessage();
	}
}
