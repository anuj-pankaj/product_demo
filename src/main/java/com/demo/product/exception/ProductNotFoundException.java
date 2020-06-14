package com.demo.product.exception;

/**
 * 
 * @author Anuj Pankaj
 * 
 * Custom exception if object does not found then throw this exception
 *
 */
public class ProductNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String message) {
		super(" Book not foud error : " + message);
	}

}
