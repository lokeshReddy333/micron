package com.otto.product.advice;

/**
 * This class captures a descriptive error message 
 * and corresponding HTTP status code
 * @author Lokeswara Jangam
 **/
public class ErrorResponse {
	private String message;
	private int status;
	
	/**
	 * Constructs a new Error Response with a specific message and status.
	 * @param message a user readable description of the error.
	 * @param status the numerical HTTP status code(eg: 404,500)
	 **/
	public ErrorResponse(String message,int status)
	{
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
