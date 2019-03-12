package com.flight_manager;

import java.util.ArrayList;
import java.util.List;

public class SystemManager {
	private static ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
	private static ArrayList<Flight> listOfFlights = new ArrayList<Flight>();
	private static ArrayList<Airline> listOfAirlines = new ArrayList<Airline>();

	public SystemManager() {

	}

	public static void createAirport(ArrayList<Airport> list, String name) {
		list.add(new Airport(name));
	}

	public static void createAirline(ArrayList<Airline> list, String name) {
		list.add(new Airline(name));
	}

	public static void createFlight(ArrayList<Flight> list, Airport port, Airline line, String origin, String destination,
			int rnd) {
		list.add(new Flight(rnd, line, port, origin, destination, seats()));
	}

	public static ArrayList<Flight> findAvailableFlights(ArrayList<Flight> list, String origin, String destination) {
		ArrayList<Flight> availableFlights = new ArrayList<Flight>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getOrigin().equals(origin)) {
				availableFlights.add(list.get(i));
			}
		}
		return availableFlights;
	}

	public static String listTheList(ArrayList<Flight> list) {
		String text = "";
		for (int i = 0; i < list.size(); i++) {
			text = text + "ID: " + list.get(i).getId() + ", Airline: " + list.get(i).getAirline().getName() + ", Airport: "
					+ list.get(i).getAirport().getName() + "\n";
		}
		return text;
	}

	

	public static ArrayList<Airport> getListOfAirports() {
		return listOfAirports;
	}

	public static void setListOfAirports(ArrayList<Airport> listOfAirports) {
		SystemManager.listOfAirports = listOfAirports;
	}

	public static ArrayList<Flight> getListOfFlights() {
		return listOfFlights;
	}

	public static void setListOfFlights(ArrayList<Flight> listOfFlights) {
		SystemManager.listOfFlights = listOfFlights;
	}

	public static ArrayList<Airline> getListOfAirlines() {
		return listOfAirlines;
	}

	public static void setListOfAirlines(ArrayList<Airline> listOfAirlines) {
		SystemManager.listOfAirlines = listOfAirlines;
	}

	public static int rnd(ArrayList<Flight> list) {
		int no = (int) (Math.random() * 10000 + 1);
		if (list.size() == 0) {
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

	public static ArrayList<Seat> seats() {
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
