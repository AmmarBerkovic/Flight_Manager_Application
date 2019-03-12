package com.flight_manager.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.flight_manager.Airline;
import com.flight_manager.Airport;
import com.flight_manager.Flight;
import com.flight_manager.SystemManager;

public class SystemManagerTest {
	String str,dest,org;
	static SystemManager sm = new SystemManager();
	private ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
	private ArrayList<Airline> listOfAirlines = new ArrayList<Airline>();
	private ArrayList<Flight> listOfFlights = new ArrayList<Flight>();
	private Airline line;
	private Airport port;
	private int rnd;
	@Before
	public void setUp() {
		line=new Airline("amm");
		port=new Airport("amm");
		dest="Amsterdam";
		org="Tuzla";
		rnd=sm.rnd(listOfFlights);
	}

	@Test
	public void sholudAddNewFormedAirportInList() {
		sm.createAirport(listOfAirports, "amm");
		str=listOfAirports.get(0).getName();
		assertEquals("amm", str);
	}
	@Test
	public void sholudAddNewFormedAirlineInList() {
		sm.createAirline(listOfAirlines, "amm");
		str=listOfAirlines.get(0).getName();
		assertEquals("amm", str);
	}
	@Test
	public void sholudAddNewFormedFlightInListPt1() {
		sm.createFlight(listOfFlights, port, line, org, dest,rnd);
		assertEquals(rnd, listOfFlights.get(0).getId());
	}
	@Test
	public void sholudAddNewFormedFlightInListPt2() {
		sm.createFlight(listOfFlights, port, line, org, dest,rnd);
		assertEquals(port, listOfFlights.get(0).getAirport());
	}
	@Test
	public void sholudAddNewFormedFlightInListPt3() {
		sm.createFlight(listOfFlights, port, line, org, dest,rnd);
		assertEquals(line, listOfFlights.get(0).getAirline());
	}
	@Test
	public void sholudAddNewFormedFlightInListPt4() {
		sm.createFlight(listOfFlights, port, line, org, dest,rnd);
		assertEquals(dest, listOfFlights.get(0).getDestination());
	}
	@Test
	public void sholudAddNewFormedFlightInListPt5() {
		sm.createFlight(listOfFlights, port, line, org, dest,rnd);
		assertEquals(org, listOfFlights.get(0).getOrigin());
	}
	@Test
	public void sholudReturnTrueIfIdDoesNotExistsInList() {
		sm.createFlight(listOfFlights, port, line, org, dest,rnd);
		rnd=sm.rnd(listOfFlights);
		assertTrue(rnd!=listOfFlights.get(0).getId());
	}
	@Test
	public void sholudReturnAllFlightsWithSpecificDestinationAndOrigin1() {
		sm.createFlight(listOfFlights, port, line, org, dest, rnd);
		ArrayList<Flight> free=sm.findAvailableFlights(listOfFlights, org, dest);
		assertEquals(org, free.get(0).getOrigin());
	}
	@Test
	public void sholudReturnAllFlightsWithSpecificDestinationAndOrigin2() {
		sm.createFlight(listOfFlights, port, line, org, dest, rnd);
		ArrayList<Flight> free=sm.findAvailableFlights(listOfFlights, org, dest);
		assertEquals(dest, free.get(0).getDestination());
	}
	@Test
	public void sholudReturnSpecificTextAboutFlightsDetails() {
		sm.createFlight(listOfFlights, port, line, org, dest, rnd);
		str=sm.listTheList(listOfFlights);
		assertEquals("ID: "+listOfFlights.get(0).getId()+", Airline: amm, Airport: amm"+"\n", str);
	}
}
