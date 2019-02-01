package com.itamp.ExceptionHandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle  {
	

	@ExceptionHandler(value=ItemNotFoundException.class)
	public ResponseEntity<Object> exceptionitem(ItemNotFoundException exception){
		return new ResponseEntity<>("CHILD NOT FOUND", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=LocationNotFoundException.class)
	public ResponseEntity<Object> exceptionLocation(LocationNotFoundException exception){
		return new ResponseEntity<>("LOCATION NOT FOUND", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=UserException.class)
	public ResponseEntity<Object> exceptionuser(UserException exception){
		return new ResponseEntity<>("USER NOT FOUND" ,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=UserRegisterException.class)
	public ResponseEntity<Object> exceptionregistration(UserRegisterException exception){
		return new ResponseEntity<>("USERNAME OR EMAIL ALREADY EXISTS",HttpStatus.NOT_FOUND);
	}
	
       
}
