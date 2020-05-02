package com.testcidenet.hulkstore.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import net.minidev.json.JSONObject;

@Document(collection = "receipts")
public class ReceiptAndExpenditure {

	@Id
	private String id;
	private String fact;
	private boolean type;
	private String description;
	private Date date;
	private JSONObject[] products;

	public ReceiptAndExpenditure(String fact, boolean type, String description, Date date, JSONObject[] products) {
		super();
		this.fact = fact;
		this.type = type;
		this.description = description;
		this.date = date;
		this.products = products;
	}

	public String getFact() {
		return fact;
	}

	public void setFact(String fact) {
		this.fact = fact;
	}

	public boolean getType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public JSONObject[] getProducts() {
		return products;
	}

	public void setProducts(JSONObject[] products) {
		this.products = products;
	}

}
