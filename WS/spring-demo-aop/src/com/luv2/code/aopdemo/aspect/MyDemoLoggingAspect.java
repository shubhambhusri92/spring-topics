package com.luv2.code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all our related advices for logging

	// let's start with an @Before advice
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before Advice on addAccount()");
	}

	// this method will match only for the specified class name
	/*
	 * @Before("execution(public void com.luv2.code.aopdemo.dao.AccountDao addAccount())"
	 * ) public void beforeAddAccountAdvice() {
	 * System.out.println("\n=====>>> Executing @Before Advice on addAccount()"); }
	 */

	// this method will match all the methods starting with add and also on return
	// type as we have put a
	// wildcard and also it'll check across all the classes
	/*
	 * @Before("execution(public void add*())") public void beforeAddAccountAdvice()
	 * { System.out.println("\n=====>>> Executing @Before Advice on addAccount()");
	 * }
	 */

	// this method will the methods starting with add as we have put a
	// wildcard and als check on the basis of return type like void,etc.
	/*
	 * @Before("execution(public void add*())") public void beforeAddAccountAdvice()
	 * { System.out.println("\n=====>>> Executing @Before Advice on addAccount()");
	 * }
	 */

	// this method will match the method starting with add and also match with any
	// return type because we have used (*) as return type
	/*
	 * @Before("execution(* add*())") public void beforeAddAccountAdvice() {
	 * System.out.println("\n=====>>> Executing @Before Advice on addAccount()"); }
	 */
}
