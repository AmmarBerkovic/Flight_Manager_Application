package com.flight_manager;

import java.util.ArrayList;
import java.util.List;

public class SystemManager {

	private ArrayList<Airport> listOfAirports=new ArrayList<Airport>();
	private ArrayList<Flight> listOfFlights=new ArrayList<Flight>();
	private ArrayList<Airline> listOfAirlines=new ArrayList<Airline>();

	public SystemManager() {

	}

	public void createAirport(ArrayList <Airport>list,String name) {
		listOfAirports.add(new Airport(name));
	}

	public Airline createAirline(String name) {
		// TODO implement
		return null;
	}

	public Flight createFlight(String name, String origin, String destination, Integer id) {
		// TODO implement
		return null;
	}

	public void createSeats(String airline, Integer flightID, Integer numberOfSeatsPerRow) {
		// TODO implement
	}

	public List<Flight> findAvailableFlights(String origin, String destination) {
		// TODO implement
		return null;
	}

	public boolean bookSeat(String airline, String flightName, int seatNumber, String row) {
		// TODO implement
		return false;
	}

	public ArrayList<Airport> getListOfAirports() {
		return listOfAirports;
	}

	public ArrayList<Flight> getListOfFlights() {
		return listOfFlights;
	}

	public ArrayList<Airline> getListOfAirlines() {
		return listOfAirlines;
	}

	

}
