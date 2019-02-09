package com.flight_manager;

import java.util.ArrayList;

public class Flight {
	// unique ID
	private int id;

	// which airline owns this flight
	private Airline airline;

	// from which airport flight takes of
	private Airport airport;

	// all seats in this flight
	private ArrayList<Seat> seats;

	// city where it takes off from
	private String origin;

	// city where the flight is going
	private String destination;

	public Flight() {

	}

	public Flight(int id, Airline line, Airport port, String origin, String destination, ArrayList<Seat> seats) {
		this.airline = line;
		this.airport = port;
		this.origin = origin;
		this.destination = destination;
		this.id = id;
		this.seats = seats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public ArrayList<Seat> getSeats() {
		return seats;
	}

	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", seats=" + seats + ", origin=" + origin
				+ ", destination=" + destination + "]";
	}

	public String availableSeats(Flight fly) {
		System.out.println("start");
		String back = "", row="";
		for (int i = 0; i < 6; i++) {
			if (i != 0)
				System.out.println();
			for (int j = 0; j < fly.seats.size(); j++) {
				if (fly.seats.get(j).getRow().equals("A")) {
					if(fly.seats.get(j).isAvailable()==false){
						if(i==0)
							row="A= ";
						if(i==1)
							row="B= ";
						if(i==2)
							row="C= ";
						if(i==3)
							row="D= ";
						if(i==4)
							row="E= ";
						if(i==5)
							row="F= ";
						System.out.print(row+fly.seats.get(j).getSeatNumber() + " ");
					}
				}
			}
		}
		return back;
	}
}
