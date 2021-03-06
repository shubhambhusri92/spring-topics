package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// add exception handling code

	// add an exception handler using @Exceptionhandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
		StudentErrorResponse errorresponse = new StudentErrorResponse();
		errorresponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorresponse.setMessage(ex.getMessage());
		errorresponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorresponse, HttpStatus.NOT_FOUND);

	}

	// add another exception handler .. to try catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
		StudentErrorResponse errorresponse = new StudentErrorResponse();
		errorresponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorresponse.setMessage(ex.getMessage());
		errorresponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorresponse, HttpStatus.BAD_REQUEST);

	}
}
