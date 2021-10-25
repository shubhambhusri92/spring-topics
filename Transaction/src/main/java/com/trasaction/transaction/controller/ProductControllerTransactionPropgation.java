package com.trasaction.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trasaction.transaction.service.ProductTransactionService;

@RestController
public class ProductControllerTransactionPropgation {

	@Autowired
	private ProductTransactionService transactionService;

	@PostMapping("/propogationrequired")
	public void usePropogationRequired() {
		transactionService.saveProductUsingPropogationRequired();
	}

	@PostMapping("/propogationsupport")
	public void usePropogationSupport() {
		transactionService.saveProductUsingSupportOnStudent();
	}

	@PostMapping("/propogationnotsupport")
	public void usePropogationNotSupport() {
		transactionService.saveProductUsingNotSupportOnStudent();
	}

	@PostMapping("/propogationrequiresnew")
	public void usePropogationRequiresNew() {
		transactionService.saveProductUsingRequiresNewOnStudent();
	}

	@PostMapping("/propogationnever")
	public void usePropogationNever() {
		transactionService.saveProductUsingNeverOnStudent();
	}
}
