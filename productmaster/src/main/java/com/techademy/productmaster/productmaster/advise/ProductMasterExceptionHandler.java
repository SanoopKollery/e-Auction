package com.techademy.productmaster.productmaster.advise;

import com.techademy.productmaster.productmaster.exception.GenericException;
import com.techademy.productmaster.productmaster.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ProductMasterExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgumentException(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ProductNotFoundException.class)
	public Map<String,String> handleProductNotFound(ProductNotFoundException ex)
	{
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("errorMessage",ex.getMessage());
		return errorMap;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(GenericException.class)
	public Map<String,String> handleGenericNotFound(GenericException ex)
	{
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("errorMessage",ex.getMessage());
		return errorMap;
	}
}
