package com.rajeshwari.exception;
import org.springframework.stereotype.Component;

@Component
public class FlightAlreadyExistException extends RuntimeException {
	private static final long serialVersionUID=1L;
}
