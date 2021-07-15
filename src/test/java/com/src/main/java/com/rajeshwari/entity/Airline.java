package com.rajeshwari.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airline {
	@Id
	private String flightNumber;
	private int noOfSeats;
	
	public Airline() {
		
	}
	
	public Airline(String flightNumber,int noOfSeats) {
		this.flightNumber=flightNumber;
		this.noOfSeats=noOfSeats;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	
	
}
