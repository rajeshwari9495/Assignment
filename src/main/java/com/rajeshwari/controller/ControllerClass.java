package com.rajeshwari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rajeshwari.entity.Airline;
import com.rajeshwari.entity.AvailableSeatResponse;
import com.rajeshwari.entity.BookTicketRequest;
import com.rajeshwari.entity.BookTicketResponse;
import com.rajeshwari.entity.ScheduleFlightRequest;
import com.rajeshwari.entity.ScheduleFlightResponse;
import com.rajeshwari.services.FlightService;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ControllerClass {
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping("/getAll")
	public List<Airline> getCourses(){
		return this.flightService.getAll();
	}
	
	//get the available no of seats in a particular flight
	@GetMapping("/getAvailableSeats")
	@ResponseBody
	public ResponseEntity<AvailableSeatResponse> getAvailableSeat(@RequestParam String flightNumber) {
		
		AvailableSeatResponse availableSeatResponse = this.flightService.getAvailableSeat(flightNumber);
		return new ResponseEntity<AvailableSeatResponse>(availableSeatResponse,HttpStatus.OK);
	}
	
	//book ticket
	@PostMapping("/bookSeat")
	public ResponseEntity<BookTicketResponse> bookTicket(@RequestBody BookTicketRequest req) {
		BookTicketResponse bookTicketResponse = this.flightService.bookTicket(req);
		return new ResponseEntity<BookTicketResponse>(bookTicketResponse,HttpStatus.CREATED);
	}
	
	//schedule flight
	@PostMapping("/scheduleFlight")
	public ResponseEntity<ScheduleFlightResponse> scheduleFlight(@RequestBody ScheduleFlightRequest req) {
		ScheduleFlightResponse scheduleFlightResponse = this.flightService.scheduleFlight(req);
		return new ResponseEntity<ScheduleFlightResponse>(scheduleFlightResponse,HttpStatus.CREATED);
	}
}
