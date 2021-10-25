package com.luv2code.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Default bean id for class is tennisCoach in case if bean id is not defined
@Component("tenniCoach")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TennisCoach implements Coach {

	private FortuneService fortuneService;

	// Autowired is Optional here DI is being used
	// if multiple constructors found mandatory to use Autowired
	// qualifier needs to passed before arg while injecting dependency using
	// constructor
	@Autowired
	public TennisCoach(@Qualifier("sadFortuneService") FortuneService fs) {
		System.out.println("Inside Tennis Coach Const.");
		fortuneService = fs;
	}

	@Override
	public String getDailyWorkOut() {
		return "Practice tennis a lot";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

	// called after bean has been instantiated
	@PostConstruct
	public void init() {
         System.out.println("Inside Init method of tennis coach");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Inside Destroy method of tennis coach");
	}

}
