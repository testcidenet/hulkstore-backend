package com.testcidenet.hulkstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
	@Id
	private String id;

	private String name;
	private String description;
	private Integer stock;

	public Product(String name, String description, Integer stock) {
		super();
		this.name = name;
		this.description = description;
		this.stock = stock;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [id=" + this.id + ", name=" + this.name + ", desc=" + this.description + ", stock=" + this.stock
				+ "]";
	}

}
