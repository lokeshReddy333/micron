package com.otto.product.advice;


/**
 * Unchecked Exception thrown when a requested Product price value greater than 0
 * @author Lokeswara Jangam
 *
 */
@SuppressWarnings("serial")
public class ProductPriceException extends RuntimeException{
	
	/**
	 * Constructs a new exception with a message detailing the invalid product price logic
	 * @param name The descriptive message containing the name that caused the failure
	 */
	public ProductPriceException(String name){
		super(name);
	}

}
