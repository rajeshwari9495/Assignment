package com.rajeshwari.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajeshwari.entity.Airline;

@Repository
public interface FlightDao extends JpaRepository<Airline, String>{
	
}
