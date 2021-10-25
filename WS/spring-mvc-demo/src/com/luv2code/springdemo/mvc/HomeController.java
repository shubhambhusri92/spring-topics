package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/api")  this is controller level request mapping so for every incoming request to this class
//will have to append this path as a prefix 
public class HomeController {

	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}

}
