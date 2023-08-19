package com.app.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.exception.ResourceNotFoundException;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
	        BindingResult bindingResult = ex.getBindingResult();
	        Map<String, String> errors = new HashMap<>();

	        bindingResult.getFieldErrors().forEach(fieldError ->
	            errors.put(fieldError.getField(), fieldError.getDefaultMessage())
	        );

	        return ResponseEntity.badRequest().body(errors);
	    }
	
	

}
