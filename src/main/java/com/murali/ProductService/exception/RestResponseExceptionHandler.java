package com.murali.ProductService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ProductServiceCustomException.class)
	public ResponseEntity<ErrorResponse> handleProductServiceException(ProductServiceCustomException p){
		
		return new ResponseEntity<>(new ErrorResponse().builder().errorMessage(p.getMessage()).errorCode(p.getErrorCode()).build(),HttpStatus.NOT_FOUND);
	}

}
