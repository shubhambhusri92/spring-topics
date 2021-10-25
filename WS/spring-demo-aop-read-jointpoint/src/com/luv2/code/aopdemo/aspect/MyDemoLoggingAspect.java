package com.luv2.code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2.code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on method");

		// diplay the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

		System.out.println("Method: " + methodSig);

		// display the method arguments
		Object[] args = theJoinPoint.getArgs();
		for (Object arg : args) {
			System.out.println(arg);

			if (arg instanceof Account) {
				// downcast and print Account specific stuff
				Account account = (Account) arg;
				System.out.println("Name : " + account.getName());
				System.out.println("Lavel: " + account.getLevel());
			}

		}

	}

}
