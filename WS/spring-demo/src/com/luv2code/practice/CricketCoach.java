package com.luv2code.practice;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class CricketCoach implements Coach, DisposableBean, InitializingBean {

	private String emailAddress;

	private String team;

	private FortuneService fortuneService;

	public CricketCoach() {
		System.out.println("Inside Cricket default");
	}

	public CricketCoach(FortuneService fs) {
		System.out.println("Inside Cricket Setter Method");
		System.out.println("Fortune service object in Cricket is" + fs);
		this.fortuneService = fs;
	}

	@Override
	public String getMessage() {
		return "Play 5 hrs a day";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void doMyStartupStuff() {
		System.out.println("Calling Life Cycle Init method of CricketCoach");
	}

	public void doMyCleanUpStuff() {
		System.out.println("Calling Life Cycle Destroy Method of CricketCoach");
	}

	/**
	 * 
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Test");

	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Inside Manual Destroy method of Disposable Bean of Cricket Coach");
	}
}
