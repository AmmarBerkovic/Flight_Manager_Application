package com.flight_manager.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.flight_manager.Airline;
import com.flight_manager.Airport;

public class AirlineTest {
	private Airline airline;
	private boolean valid;
	private String str;
	private ArrayList<Airline> list = new ArrayList<Airline>();

	@Before
	public void setUp() {
		airline = new Airline("Fly");
		valid = false;
		str = "air";
	}

	@Test
	public void shouldReturnFalseIfNameHasMoreThan6Letters() {
		str = "airline";
		valid = airline.checkNameLength(str);
		assertFalse(valid);
	}

	@Test
	public void shouldReturnTrueIfNameHasLessThan6Letters() {
		valid = airline.checkNameLength(str);
		assertTrue(valid);
	}

	@Test
	public void sholudReturnFalseIfNamesLengthIsZero() {
		str = "";
		valid = airline.checkNameLength(str);
		assertFalse(valid);
	}

	@Test
	public void shouldReturnTrueIfNameContainsOnlyLetter() {
		valid = airline.checkIfNameHasOnlyLetters(str);
		assertTrue(valid);
	}

	@Test
	public void shouldReturnFalseIfNameDoesNotContainsOnlyLetter() {
		str = "43Zla";
		valid = airline.checkIfNameHasOnlyLetters(str);
		assertFalse(valid);
	}

	@Test
	public void sholudReturnTrueIfNameDoesNotExists() {
		list.add(airline);
		valid = airline.checkNameExistence(list, str);
		assertTrue(valid);
	}

	@Test
	public void sholudReturnFalseIfNameExists() {
		list.add(airline);
		str = "Fly";
		valid = airline.checkNameExistence(list, str);
		assertFalse(valid);
	}

}
