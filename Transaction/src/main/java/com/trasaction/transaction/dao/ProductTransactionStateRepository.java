package com.trasaction.transaction.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trasaction.transaction.model.Product;

public interface ProductTransactionStateRepository extends JpaRepository<Product, Integer> {

}
