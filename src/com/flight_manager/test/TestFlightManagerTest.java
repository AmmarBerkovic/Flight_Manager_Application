package com.flight_manager.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.flight_manager.TestFlightManager;

public class TestFlightManagerTest {
	private String str;

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

}
