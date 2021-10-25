package com.luv2code.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BasketBallCoach implements Coach {

	// here autowired can be used directly on fields and accomplished by using java
	// Reflection APi
	@Qualifier("happyFortuneService")
	@Autowired
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkOut() {
		return "Play harder BasketBall";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

}
