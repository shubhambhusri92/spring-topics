package com.luv2code.practice;

public class BasketBallCoach implements Coach {

	private String name;

	private String citizen;

	private FortuneService fortuneService;

	public BasketBallCoach() {
		System.out.println("Make Basket defualt constructor");
	}

	@Override
	public String getMessage() {
		return "Play good basketball";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

	public void setFortuneService(FortuneService fs) {
		System.out.println("Fortune service object in Basket is" + fs);
		this.fortuneService = fs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCitizen() {
		return citizen;
	}

	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}

	public void doMyStartupStuff() {
		System.out.println("Calling Life Cycle Init method of BasketBallCoach");
	}

	public void doMyCleanUpStuff() {
		System.out.println("Calling Life Cycle Destroy Method of BasketBallCoach");
	}

}
