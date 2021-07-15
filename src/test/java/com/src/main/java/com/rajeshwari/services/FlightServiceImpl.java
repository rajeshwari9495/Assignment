package com.rajeshwari.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.rajeshwari.dao.FlightDao;
import com.rajeshwari.entity.Airline;
import com.rajeshwari.entity.AvailableSeatResponse;
import com.rajeshwari.entity.BookTicketRequest;
import com.rajeshwari.entity.BookTicketResponse;
import com.rajeshwari.entity.ScheduleFlightRequest;
import com.rajeshwari.entity.ScheduleFlightResponse;
import com.rajeshwari.exception.EmptyInputException;
import com.rajeshwari.exception.FlightAlreadyExistException;
import com.rajeshwari.exception.ResourceNotFoundException;
import com.rajeshwari.exception.SeatNotAvailableException;

import javax.persistence.EntityNotFoundException;

@Service
public class FlightServiceImpl implements FlightService{
	static int seatNumber=1;
	
	@Autowired
	private FlightDao flightDao;
	
	
	public List<Airline> getAll(){
		List<Airline> list = new ArrayList<>();
		list = this.flightDao.findAll();
		return list;
		
	}
	
	public AvailableSeatResponse getAvailableSeat(String flightNumber) {
		if(flightNumber==null) throw new EmptyInputException();
		
		Airline airline=null;
		
		AvailableSeatResponse res = null;
		
		if(!this.flightDao.findById(flightNumber).isEmpty()){
			 airline = this.flightDao.getById(flightNumber);
			 res = new AvailableSeatResponse("Success",airline.getNoOfSeats());
		}
		else {
			 throw new ResourceNotFoundException();
		 }
		 
		
		 return res;
	}

	public BookTicketResponse bookTicket(BookTicketRequest req) {
		if(req.getFlightNumber()==null) throw new EmptyInputException();
		
		Airline airline = null;
		
		if(!this.flightDao.findById(req.getFlightNumber()).isEmpty()){
			 airline = this.flightDao.getById(req.getFlightNumber());
		}
		else {
			 throw new ResourceNotFoundException();
		 }
		
		BookTicketResponse res = new BookTicketResponse();
		int noOfSeat = airline.getNoOfSeats();
		if(noOfSeat>0) {
			res.setStatus("Success");
			res.setSeatNumber(seatNumber++);
			airline = new Airline(req.getFlightNumber(),noOfSeat-1);
			this.flightDao.save(airline);
		}
		else {
			throw new SeatNotAvailableException();
		}
		
		return res;
	}

	public ScheduleFlightResponse scheduleFlight(ScheduleFlightRequest req) {
		if(req.getFlightNumber()==null) throw new EmptyInputException();
		
		Airline airline = new Airline(req.getFlightNumber(),req.getNoOfSeats());
		
		if(!this.flightDao.findById(req.getFlightNumber()).isEmpty()){
			throw new FlightAlreadyExistException();
		}
		else
			this.flightDao.save(airline);
		
		
		
		ScheduleFlightResponse res = new ScheduleFlightResponse();
		res.setStatus("Success");
		return res;
	}
}
