package com.demo.product.resources;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
/**
 * 
 * @author Anuj Pankaj
 *
 * Response Object to use API call
 *
 */
public class ProductResponse {
	
	private  HttpStatus status;
	private String message;
	private List<String> products;
	private Map<String, List<Product>> productMap;
	public ProductResponse(HttpStatus status, String message, List<String> products,Map<String, List<Product>> productSoldMap) {
		super();
		this.status = status;
		this.message = message;
		this.products = products;
		this.productMap = productSoldMap;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, List<Product>> getProductMap() {
		return productMap;
	}
	public void setProductMap(Map<String, List<Product>> productMap) {
		this.productMap = productMap;
	}
	public List<String> getProducts() {
		return products;
	}
	public void setProducts(List<String> products) {
		this.products = products;
	}
	
}