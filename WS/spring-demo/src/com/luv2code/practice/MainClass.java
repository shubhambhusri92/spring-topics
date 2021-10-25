package com.luv2code.practice;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		ApplicationContext ctxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach ch = ctxt.getBean("myBasketBallCoach",BasketBallCoach.class);
		
		
		
		
		// load xml file
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get bean from xml BasketBallCoach coach =

		Coach coach = context.getBean("myBasketBallCoach", BasketBallCoach.class);
		Coach coach1 = context.getBean("myBasketBallCoach", BasketBallCoach.class);

		System.out.println(coach);
		System.out.println(coach1);
		System.out.println("Memory Address Verified" + (coach == coach1));

		CricketCoach ccoach = context.getBean("myCricketCoach", CricketCoach.class);
		// get message from bean
		System.out.println("BasketBall Coach Message is" + coach.getMessage());
		System.out.println(coach.getFortune());
		//System.out.println(coach.getCitizen());
		//System.out.println(coach.getName());

		System.out.println(ccoach.getMessage());
		System.out.println(ccoach.getFortune());
		System.out.println(ccoach.getEmailAddress());
		System.out.println(ccoach.getTeam());
		// close the container
		System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
		context.close();
	}
}
