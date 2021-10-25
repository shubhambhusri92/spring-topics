package com.luv2code.springdemo.mvc;

import org.springframework.web.bind.annotation.RequestMapping;

public class DataController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

}
