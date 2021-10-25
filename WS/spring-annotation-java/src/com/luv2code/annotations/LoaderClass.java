package com.luv2code.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoaderClass {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		TennisCoach tennisCoach = ctx.getBean("tenniCoach", TennisCoach.class);
		TennisCoach tennisCoach1 = ctx.getBean("tenniCoach", TennisCoach.class);
		System.out.println("Memory Equal or not" + (tennisCoach == tennisCoach1));

		System.out.println(tennisCoach.getDailyWorkOut());
		System.out.println(tennisCoach.getFortune());
		CricketCoach ccoach = ctx.getBean("cricketCoach", CricketCoach.class);
		System.out.println(ccoach.getDailyWorkOut());
		System.out.println(ccoach.getFortune());
		System.out.println("Cricket Coach Team name " + ccoach.getTeamName());
		System.out.println("Cricket Coach Team email " + ccoach.getEmail());
		BasketBallCoach bcoach = ctx.getBean("basketBallCoach", BasketBallCoach.class);
		System.out.println(bcoach.getDailyWorkOut());
		System.out.println(bcoach.getFortune());
		ctx.close();
	}
}
