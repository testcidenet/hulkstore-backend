package com.testcidenet.hulkstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.testcidenet.hulkstore.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	List<Product> findByNameContainingIgnoreCase(String name);
	Optional<Product> findByNameIgnoreCase(String name);
	Page<Product> findByNameContainingIgnoreCase(String name, PageRequest pageRequest);
}
