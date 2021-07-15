package com.rajeshwari.services;

import java.util.List;

import com.rajeshwari.entity.Airline;
import com.rajeshwari.entity.AvailableSeatResponse;
import com.rajeshwari.entity.BookTicketRequest;
import com.rajeshwari.entity.BookTicketResponse;
import com.rajeshwari.entity.ScheduleFlightRequest;
import com.rajeshwari.entity.ScheduleFlightResponse;


public interface FlightService {
	public AvailableSeatResponse getAvailableSeat(String flightNumber);
	public BookTicketResponse bookTicket(BookTicketRequest req);
	public ScheduleFlightResponse scheduleFlight(ScheduleFlightRequest req);
	public List<Airline> getAll();
}
