package com.flight_manager;

import java.util.ArrayList;
import java.util.List;

public class SystemManager {
	static SystemManager sm = new SystemManager();
	private ArrayList<Airport> listOfAirports=new ArrayList<Airport>();
	private ArrayList<Flight> listOfFlights=new ArrayList<Flight>();
	private ArrayList<Airline> listOfAirlines=new ArrayList<Airline>();

	public SystemManager() {

	}

	public void createAirport(ArrayList <Airport>list,String name) {
		list.add(new Airport(name));
	}
	public void createAirline(ArrayList <Airline>list,String name) {
		list.add(new Airline(name));
	}
	public void createFlight(ArrayList <Flight>list,Airport port,Airline line , String origin, String destination) {
		list.add(new Flight(rnd(),line,port,origin,destination,seats()));
	}

	public void createSeats(String airline, int flightID, int numberOfSeatsPerRow) {
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
	public int rnd() {
		int no=(int)(Math.random()*10000+1);
		for (int i = 0; i < listOfFlights.size(); i++) {
			if(no==listOfFlights.get(i).getId()) {
				i=0;
				no=(int)(Math.random()*10000+1);
			}
		}
		return no;
	}
	public ArrayList <Seat> seats() {
		String row="";
		ArrayList<Seat> seat = new ArrayList <Seat>();
		for (int i = 0; i < 6; i++) {
			if(i==0) 
				row="A";
			else if(i==1)
				row="B";
			else if(i==2)
				row="C";
			else if(i==3)
				row="D";
			else if(i==4)
				row="E";
			else if(i==5)
				row="F";
			for (int j = 0; j < 15; j++) {
				seat.add(new Seat(row,j,false));
			}
		}
		return seat;
	}
}
