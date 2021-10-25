package com.luv2code.annotations;

import org.springframework.stereotype.Component;

@Component
public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Practice otherwise you'll loose the match";
	}

}
