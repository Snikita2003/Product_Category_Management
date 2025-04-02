package com.prod.repo;

import com.prod.entity.Category;
import com.prod.entity.Product;

public class Responce
{
	
	
	private String message;
	 private Category cat;
	 private Product prod;
	 Long id;
	 
	 
	 public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Category getCat() {
		return cat;
	}
	public void setCat(Category cat) {
		this.cat = cat;
	}
	public Product getProd() {
		return prod;
	}
	public void setProd(Product prod) {
		this.prod = prod;
	}

	 
	public Responce() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Responce(String message, Category cat, Product prod) {
		
		this.message = message;
		this.cat = cat;
		this.prod = prod;
	}
	
	public Responce(String message, Long id) {
		
		this.message = message;
		this.id=id;
	}
	 
	 
	 
	
}