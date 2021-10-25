package com.luv2code.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	@Value("${foo.email}")
	private String teamName;

	@Value("${foo.team}")
	private String email;

	private FortuneService fortuneService;

	@Override
	public String getDailyWorkOut() {
		return "Pratice cricket 5 hrs a day";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

	// autowired mandatory for using DI in setter method
	@Qualifier("RESTFortuneService")
	@Autowired
	public void setFortuneService(FortuneService fs) {
		System.out.println("Inside Setter Method of Cricket Coach");
		this.fortuneService = fs;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
