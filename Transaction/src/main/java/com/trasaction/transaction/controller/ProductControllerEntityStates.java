package com.trasaction.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trasaction.transaction.model.Product;
import com.trasaction.transaction.service.ProductService;

// controller for EntityStates
@RestController
public class ProductControllerEntityStates {

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public void addProduct(@RequestParam String productName) {
		productService.addProduct(productName);
	}

	@GetMapping("/product")
	public Product findProduct() {
		return productService.findProduct();
	}

	@DeleteMapping("/product")
	public void removeProduct() {
		productService.removeProduct();
	}

	@GetMapping("/product/merge")
	public void mergeAndDetachProduct() {
		productService.mergeAndDetachProduct();
	}

	@PostMapping("/product/refresh")
	public void refresh() {
		productService.refreshAndFlush();
	}
}
