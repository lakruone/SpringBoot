package com.itamp.ExceptionHandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle  {
	

	@ExceptionHandler(value=ItemNotFoundException.class)
	public ResponseEntity<Object> exceptionitem(ItemNotFoundException exception){
		return new ResponseEntity<>("child not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=LocationNotFoundException.class)
	public ResponseEntity<Object> exceptionLocation(LocationNotFoundException exception){
		return new ResponseEntity<>("location not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=UserException.class)
	public ResponseEntity<Object> exceptionuser(UserException exception){
		return new ResponseEntity<>("user not found" ,HttpStatus.NOT_FOUND);
	}
	
	
       
}
