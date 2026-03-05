package com.pnc.micron.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ProductAdviceController {

	@ExceptionHandler(ProductNameNotFoundException.class)
	public ResponseEntity<ErrorResponse> HandleBadRequestException(ProductNameNotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(ProductPriceException.class)
	public ResponseEntity<ErrorResponse> HandleProductPriceException(ProductPriceException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
		
	}
	
}
