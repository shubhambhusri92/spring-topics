package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject customer dao
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		// get the customers from the dao
		List<Customer> list = customerService.getCustomers();

		theModel.addAttribute("customers", list);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String addCustomer(Model theModel) {

		theModel.addAttribute("customer", new Customer());

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model model) {

		// get the customer from service
		Customer customer = customerService.getCustomerById(theId);

		// set customer as model attribute to pre-populate the form
		model.addAttribute("customer", customer);

		// send over to our form
		return "customer-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {

		// get the customer from service
		customerService.deleteById(theId);
		return "redirect:/customer/list";

	}

}
