package com.otto.product.advice;

/**
 * Unchecked Exception thrown when a requested Product Name empty or null
 * @author Lokeswara Jangam
 *
 */
@SuppressWarnings("serial")
public class ProductNameNotFoundException extends RuntimeException {
	/**
	 * Constructs a new exception with a message detailing the invalid product name
	 * @param name The descriptive message containing the name that caused the failure
	 */
	public ProductNameNotFoundException(String name) {
		super(name);
	}

}
