package com.otto.product.advice;

/**
 * Unchecked Exception thrown when a requested Product ID does not exist in the data base
 * @author Lokeswara Jangam
 *
 */
@SuppressWarnings("serial")
public class ProductIdNotFoundException extends RuntimeException {

	/**
	 * Constructs a new exception with a specific error message
	 * @param name The descriptive message (Usually containing the missing Id)
	 * 
	 */
	public ProductIdNotFoundException(String name) {
		super(name);
	}

}
