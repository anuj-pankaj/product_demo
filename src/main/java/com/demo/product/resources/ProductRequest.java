package com.demo.product.resources;

import java.util.List;
/**
 * 
 * @author Anuj Pankaj
 *
 * RequestObject to use API call
 *
 */
public class ProductRequest {
	
	private String emailId;
	private List<Integer> productIds; 
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public List<Integer> getProductIds() {
		return productIds;
	}
	public void setProductIds(List<Integer> productIds) {
		this.productIds = productIds;
	}
}
