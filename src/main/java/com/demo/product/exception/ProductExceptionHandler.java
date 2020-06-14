package com.demo.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 
 * @author Anuj Pankaj
 * 
 * Exception Handler class for the Product Application
 *
 */
@RestControllerAdvice
public class ProductExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler( ProductNotFoundException.class)
    public ErrorResponse handleProductNotFoundException(ProductNotFoundException ex) {       
        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler( Exception.class)
	public ErrorResponse handleAllOthers(Exception ex){
		return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
	}
}
