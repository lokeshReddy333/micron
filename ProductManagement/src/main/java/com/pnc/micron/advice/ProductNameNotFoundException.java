package com.pnc.micron.advice;

public class ProductNameNotFoundException extends RuntimeException {
	public ProductNameNotFoundException(String name) {
		super(name);
	}

}
