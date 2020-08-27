package com.employee.management.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EmpNotFoundException.class)
	public final ResponseEntity<ErrorMessage> empNotFoundException(EmpNotFoundException ex){
		
		ErrorMessage exceptionMessage=new ErrorMessage(ex.getMessage(),"Error while loading the emp details");
		
		return new ResponseEntity<ErrorMessage>(exceptionMessage,new HttpHeaders(),HttpStatus.NO_CONTENT);
	}
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMessage> defaultException(Exception ex){
		
		ErrorMessage exceptionMessage=new ErrorMessage(ex.getMessage(),"Default Error");
		
		return new ResponseEntity<ErrorMessage>(exceptionMessage,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

                                                                                                   
    
