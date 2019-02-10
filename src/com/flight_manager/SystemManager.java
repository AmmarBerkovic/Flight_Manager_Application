package com.flight_manager;

import java.util.ArrayList;
import java.util.List;

public class SystemManager {
	static SystemManager sm = new SystemManager();
	private ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
	private ArrayList<Flight> listOfFlights = new ArrayList<Flight>();
	private ArrayList<Airline> listOfAirlines = new ArrayList<Airline>();

	public SystemManager() {

	}

	public void createAirport(ArrayList<Airport> list, String name) {
		list.add(new Airport(name));
	}

	public void createAirline(ArrayList<Airline> list, String name) {
		list.add(new Airline(name));
	}

	public void createFlight(ArrayList<Flight> list, Airport port, Airline line, String origin, String destination,int rnd) {
		list.add(new Flight(rnd, line, port, origin, destination, seats()));
	}

	public ArrayList<Flight> findAvailableFlights(ArrayList<Flight> list, String origin, String destination) {
		ArrayList<Flight> availableFlights = new ArrayList<Flight>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getOrigin().equals(origin)) {
				availableFlights.add(list.get(i));
			}
		}
		return availableFlights;
	}

	public String listTheList(ArrayList<Flight> list) {
		String text = "";
		for (int i = 0; i < list.size(); i++) {
			text = text + "ID: " + list.get(i).getId() + ", " + list.get(i).getAirline().getName() + ", "
					+ list.get(i).getAirport().getName() + "\n";
		}
		return text;
	}

	public boolean bookSeat(String airline, String airport, int seatNumber, String row) {
		
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

	public int rnd(ArrayList<Flight> list) {
		int no = (int) (Math.random() * 10000 + 1);
		if(list.size()==0) {
			return no;
		}
		for (int i = 0; i < list.size(); i++) {
			if (no == list.get(i).getId()) {
				i = 0;
				no = (int) (Math.random() * 10000 + 1);
			}
		}
		return no;
	}

	public ArrayList<Seat> seats() {
		String row = "";
		ArrayList<Seat> seat = new ArrayList<Seat>();
		for (int i = 0; i < 6; i++) {
			if (i == 0)
				row = "A";
			else if (i == 1)
				row = "B";
			else if (i == 2)
				row = "C";
			else if (i == 3)
				row = "D";
			else if (i == 4)
				row = "E";
			else if (i == 5)
				row = "F";
			for (int j = 0; j < 15; j++) {
				seat.add(new Seat(row, j, false));
			}
		}
		return seat;
	}
}
