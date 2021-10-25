package com.luv2code.annotations;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "this is a rest fortune service";
	}

}
