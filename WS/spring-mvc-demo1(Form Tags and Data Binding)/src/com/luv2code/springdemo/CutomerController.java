package com.luv2code.springdemo;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CutomerController {

	// add an init binder...to convert trim input strings
	// remove leading and trailing whitespace
	// resolve issue for our validation
	@InitBinder
	public void initBind(WebDataBinder theWebDataBinder) {
		// StringTrimmerEditor class in spring api that removes whitespaces : leading and trailing
		// true means it will trim to null if entire is whitespace and also remove whitespace if found extra
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		theWebDataBinder.registerCustomEditor(String.class, ste);
	}

	@RequestMapping("/showForm")
	public String showForm(Model themodel) {
		themodel.addAttribute("customer", new Customer());
		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {

		System.out.println("First name:|"+ theCustomer.getFirstName() + "|");
		System.out.println("Last name:|"+ theCustomer.getLastName() + "|");
		System.out.println("freePasses:|"+ theCustomer.getFreePasses() + "|");
		System.out.println("postalCode:|"+ theCustomer.getPostalCode() + "|");
		
		if (theBindingResult.hasErrors())
			return "customer-form";

		else
			return "customer-confirmation";
	}
}
