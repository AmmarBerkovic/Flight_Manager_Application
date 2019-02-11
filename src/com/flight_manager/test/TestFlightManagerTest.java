package com.flight_manager.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.flight_manager.Airport;
import com.flight_manager.SystemManager;
import com.flight_manager.TestFlightManager;

public class TestFlightManagerTest {
	private String str;
	static SystemManager sm = new SystemManager();
	private ArrayList<Airport> listOfAirport = new ArrayList<Airport>();
	@Before
	public void setUp() {
		str = "Testing";
	}

	@Test
	public void sholudReturnMenuIfTheArgumentIsZero() {
		str = TestFlightManager.print(0);
		assertEquals(
				"============================\n1 - Create Airport\n2 - Create Airline\n3 - Create flight\n4 - Book a seat on a flight\n5 - Izlaz\n============================",
				str);
	}

	@Test
	public void sholudReturnSpecificMessageIfTheArgumentIsOne() {
		str = TestFlightManager.print(1);
		assertEquals("============================\nA successful action!", str);
	}

	@Test
	public void sholudReturnSpecificMessageIfTheArgumentIsTwo() {
		str = TestFlightManager.print(2);
		assertEquals("============================\nFailed action!", str);
	}

	@Test
	public void sholudReturnSpecificMessageIfTheArgumentIsThree() {
		str = TestFlightManager.print(3);
		assertEquals("Error: Name must consist only alphbetical characters.", str);
	}

	@Test
	public void sholudReturnSpecificMessageIfTheArgumentIsFour() {
		str = TestFlightManager.print(4);
		assertEquals("Input: ", str);
	}

	@Test
	public void sholudReturnSpecificMessageIfTheArgumentIsFive() {
		str = TestFlightManager.print(5);
		assertEquals("Error: Name is already in use.", str);
	}
	@Test
	public void sholudReturnSpecificMessageIfTheArgumentIsSix() {
		str = TestFlightManager.print(6);
		assertEquals("============================", str);
	}
	@Test
	public void shouldReturnEnteredNumber() {
		assertEquals(1,TestFlightManager.ScanInt());
	}
	

}
