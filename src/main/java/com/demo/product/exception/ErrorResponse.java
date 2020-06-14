package com.demo.product.exception;

import org.springframework.http.HttpStatus;
/**
 * 
 * @author Anuj Pankaj
 *
 * Error Object, whenever there is exception this object is passed to user
 */
public class ErrorResponse {

	private final HttpStatus status;
	private final String message;

	public ErrorResponse(HttpStatus status, String message) {

		this.status = status;
		this.message = message;
	}

	public int getStatus() {

		return status.value();
	}

	public String getMessage() {

		return message;
	}

	@Override
	public String toString() {
		return "ErrorResponse [status=" + status + ", message=" + message + "]";
	}

}
