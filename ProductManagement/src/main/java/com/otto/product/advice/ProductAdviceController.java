package com.otto.product.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global Exception handler for product-related operations.
 * @author Lokeswara Jangam
**/
@RestControllerAdvice
public class ProductAdviceController {

	/**
	 * Handles exceptions thrown when a product name is not found in the system.
	 * @param ex the caught ProductNameNotFoundException instance.
	 * @return A ResponseEntity containing an ErrorResponse and a 404 bad Request status.
	 */
	@ExceptionHandler(ProductNameNotFoundException.class)
	public ResponseEntity<ErrorResponse> HandleBadRequestException(ProductNameNotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
		
	}
	/**
	 * Handles exceptions related to invalid product pricing logic.
	 * @param ex the caught ProductPriceException instance.
	 * @return A ResponseEntity containing an ErrorResponse and a 404 bad Request status.
	 */
	@ExceptionHandler(ProductPriceException.class)
	public ResponseEntity<ErrorResponse> HandleProductPriceException(ProductPriceException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
		
	}
	/**
	 * Handles exceptions thrown when a product Id can not be located.
	 * @param ex the caught ProductPriceException instance.
	 * @return A ResponseEntity containing an ErrorResponse and a 404 bad Request status.
	 */
	@ExceptionHandler(ProductIdNotFoundException.class)
	public ResponseEntity<ErrorResponse> HandleProductIdException(ProductIdNotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
		
	}
	
}
