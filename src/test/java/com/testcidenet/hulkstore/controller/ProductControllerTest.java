package com.testcidenet.hulkstore.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.testcidenet.hulkstore.repository.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
class ProductControllerTest {

	@Autowired
	ProductRepository productRepository;

	@Test
	public void readsFirstPageCorrectly() {

		//Page<Product> products = productRepository.findAll(PageRequest.of(0, 10));
		
	}

}
