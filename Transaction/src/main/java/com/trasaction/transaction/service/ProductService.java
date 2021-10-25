package com.trasaction.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trasaction.transaction.dao.ProductDao;
import com.trasaction.transaction.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public void addProduct(String productName) {
		productDao.addProduct(productName);
	}

	public Product findProduct() {
		return productDao.findProduct();
	}

	public void removeProduct() {
		productDao.removeProduct();
	}

	public void mergeAndDetachProduct() {
		productDao.mergeDetachAndClear();
	}

	public void refreshAndFlush() {
		productDao.refreshAndFlush();
	}

}
