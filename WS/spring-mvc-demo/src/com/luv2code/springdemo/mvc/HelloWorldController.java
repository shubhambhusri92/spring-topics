package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api") // --> Parent Mapping
public class HelloWorldController {

	// controller method to show the initial html form
	@RequestMapping("/showForm") // --> Sub mapping (relative)
	public String showForm() {
		return "helloworld-form";
	}

	// controller method to process the html form
	@RequestMapping("/processForm") // --> Sub mapping (relative)
	public String processForm() {
		return "helloworld";
	}

	// controller method to read form data and
	// add data to model
	@RequestMapping("/processFormVersionTwo") // --> Sub mapping (relative)
	public String letsShouteDude(HttpServletRequest request, Model model) {
		// read request parameter from the HTML form
		String theName = request.getParameter("studentName");

		// convert data to upper case
		theName = theName.toUpperCase();

		// create the message
		String result = "Yo!" + theName;

		// add message to model
		model.addAttribute("message", result);

		return "helloworld";
	}

	// here assign theName to value of request parameter
	@RequestMapping("/processFormVersionThree") // --> Sub mapping (relative)
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {

		// convert data to upper case
		theName = theName.toUpperCase();

		// create the message
		String result = "Hey This is V3!" + theName;

		// add message to model
		model.addAttribute("message", result);

		return "helloworld";
	}
	
	
	@RequestMapping("/io") // --> Sub mapping (relative)
	public String processFormVersionTe() {

		return "helloworld";
	}

}
