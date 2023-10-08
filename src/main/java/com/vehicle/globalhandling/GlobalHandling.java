package com.vehicle.globalhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vehicle.customexception.BrandNotFoundException;
import com.vehicle.customexception.IdNotFoundException;
import com.vehicle.customexception.InvalidBoardException;

@RestControllerAdvice
public class GlobalHandling {
	
	@ExceptionHandler(BrandNotFoundException.class)
	public ResponseEntity<Object> brandHandle() {
		return new ResponseEntity<Object>("Brand doesn't available",HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(InvalidBoardException.class)
	public ResponseEntity<Object> boardHandle() {
		return new ResponseEntity<Object>("Board doesn't available",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> idHandle(){
		return new ResponseEntity<Object>("id doesn't available",HttpStatus.BAD_REQUEST);
	}
	
}
