package com.testcidenet.hulkstore.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testcidenet.hulkstore.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	List<Product> findByNameContainingIgnoreCase(String name);	
}
