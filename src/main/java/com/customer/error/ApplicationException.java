package com.customer.error;

public class ApplicationException extends RuntimeException{
	
	private String message;
	
	private static final long serialVersionUID = 1L;
	
	public ApplicationException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
