package com.org.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.org.repository.IdNotFoundException;


@ControllerAdvice
public class ExceptionHolder {
	
	
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> myException(IdNotFoundException e) {
		
		long millis= System.currentTimeMillis();
		String message= e.getMessage();
		int status=HttpStatus.NOT_FOUND.value();
		
		
		StudentErrorResponse error= new StudentErrorResponse();
		
		error.setMessage(message);
		error.setStatus(status);
		error.setTimestamp(millis);
		return new ResponseEntity<StudentErrorResponse>(error,HttpStatus.NOT_FOUND);
		
	}
	

}
