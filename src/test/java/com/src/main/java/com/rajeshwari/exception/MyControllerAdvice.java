package com.rajeshwari.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception){
		ErrorDetails errorDetails = new ErrorDetails("Failure");
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SeatNotAvailableException.class)
	public ResponseEntity<?> handleSeatNotAvailableException(SeatNotAvailableException exception){
		ErrorDetailsMessage errorDetails = new ErrorDetailsMessage("Failure","Tickets full");
		return new ResponseEntity<ErrorDetailsMessage>(errorDetails,HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(FlightAlreadyExistException.class)
	public ResponseEntity<?> handleFlightAlreadyExistException(FlightAlreadyExistException exception){
		ErrorDetailsMessage errorDetails = new ErrorDetailsMessage("Failure","Flight already exists");
		return new ResponseEntity<ErrorDetailsMessage>(errorDetails,HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<?> handleEmptyInputException(EmptyInputException exception){
		ErrorDetailsMessage errorDetails = new ErrorDetailsMessage("Failure","Input passed is empty");
		return new ResponseEntity<ErrorDetailsMessage>(errorDetails,HttpStatus.NOT_FOUND);
	}
}
