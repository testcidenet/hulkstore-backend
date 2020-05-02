package com.testcidenet.hulkstore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.testcidenet.hulkstore.controller.ProductController;
import com.testcidenet.hulkstore.controller.ReceiptAndExpenditureController;


@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {

	@Autowired
	private ProductController productController;

	@Autowired
	private ReceiptAndExpenditureController receiptAndExpenditureController;


	@Test
	void contextLoads() {
		assertNotNull(productController);
		assertNotNull(receiptAndExpenditureController);
	}

	@Test
	public void productControllerTest() {
		//create product
		//get a product
		//find a product
		//delete a product
		//find product that no exist
		assertEquals(HttpStatus.OK, productController.getAllProducts("").getStatusCode());
		assertEquals(HttpStatus.OK, productController.getAllProducts(null).getStatusCode());
		assertEquals(HttpStatus.NO_CONTENT, productController.getAllProducts("sdfsdfdsgdsf").getStatusCode());
	}
	
	@Test
	public void receiptAndExpenditureControllerTest() {
		assertEquals(HttpStatus.NO_CONTENT, receiptAndExpenditureController.getAllReceipts("").getStatusCode());
		assertEquals(HttpStatus.NO_CONTENT, receiptAndExpenditureController.getAllReceipts(null).getStatusCode());
	}
	

}
