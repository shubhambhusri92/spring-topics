package com.trasaction.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.trasaction.transaction.dao.ProductTransactionStateRepository;
import com.trasaction.transaction.model.Product;

@Service
public class ProductTransactionService {

	@Autowired
	private ProductTransactionStateRepository transactionService;

	@Autowired
	StudentServiceTransactional studentService;

	@Transactional(propagation = Propagation.REQUIRED) // Or @Transactional as
	// it's by default embedded with this
	// annotation
	public void saveProductUsingPropogationRequired() {
		studentService.saveStudentUsingPropogationRequired();
		Product product = new Product();
		product.setName("Brooks");
		transactionService.save(product);
	}

	@Transactional // this is calling service
	public void saveProductUsingSupportOnStudent() {
		studentService.saveStudentUsingSupports();
		Product product = new Product();
		product.setName("Brooks");
		transactionService.save(product);
	}

	@Transactional // this is calling service
	public void saveProductUsingNotSupportOnStudent() {
		try {
			studentService.saveStudentUsingNotSupports();
		} catch (ArithmeticException ex) {
			System.out.println("Exception  :" + ex.getMessage());
		}
		Product product = new Product();
		product.setName("Brooks");
		System.out.println("Trying to Save Product");
		transactionService.save(product);
	}

	@Transactional // this is calling service
	public void saveProductUsingRequiresNewOnStudent() {
		try {
			studentService.saveProductUsingRequiresNewOnStudent();
		} catch (ArithmeticException ex) {
			System.out.println("Exception  :" + ex.getMessage());
		}
		Product product = new Product();
		product.setName("Brooks");
		System.out.println("Trying to Save Product");
		transactionService.save(product);
	}

	//@Transactional // this is calling service
	public void saveProductUsingNeverOnStudent() {
		try {
			studentService.saveProductUsingNeverOnStudent();
		} catch (ArithmeticException ex) {
			System.out.println("Exception  :" + ex.getMessage());
		}
		Product product = new Product();
		product.setName("Brooks");
		System.out.println("Trying to Save Product");
		transactionService.save(product);
	}

}
