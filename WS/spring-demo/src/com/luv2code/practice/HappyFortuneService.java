package com.luv2code.practice;

public class HappyFortuneService implements FortuneService {

	public HappyFortuneService()
	{
	   System.out.println("inside fortune constructor");	
	}
	
	@Override
	public String getFortune() {
		return "Today is your lucky day";
	}

}
