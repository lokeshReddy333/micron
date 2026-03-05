package com.pnc.micron.advice;

public class ProductPriceException extends RuntimeException{
	public ProductPriceException(String name){
		super(name);
	}

}
