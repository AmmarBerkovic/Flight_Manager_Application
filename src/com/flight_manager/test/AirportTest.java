package com.flight_manager.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.flight_manager.Airport;

public class AirportTest {
	private Airport airport;
	private boolean valid;
	private String str="";
	private ArrayList<Airport> list=new ArrayList<Airport>();

	@Before
	public void setUp() {
		airport = new Airport("Fly");
		valid = false;
		str="air";
	}

	@Test
	public void shouldReturnTrueIfNameHas3Letters() {
		boolean valid = airport.checkNameLength(str);
		assertTrue(valid);
	}

	@Test
	public void shouldReturnFalseIfNameHasMoreThan3Letters() {
		str="airport";
		valid = airport.checkNameLength(str);
		assertFalse(valid);
	}

	@Test
	public void shouldReturnFalseIfNameHasNoLetters() {
		str="";
		valid = airport.checkNameLength(str);
		assertFalse(valid);
	}

	@Test
	public void shouldReturnTrueIfNameContainsOnlyLetter() {
		valid = airport.checkIfNameHasOnlyLetters(str);
		assertTrue(valid);
	}

	@Test
	public void shouldReturnFalseIfNameDoesNotContainsOnlyLetter() {
		str="43Zla";
		valid = airport.checkIfNameHasOnlyLetters(str);
		assertFalse(valid);
	}
	@Test
	public void sholudReturnTrueIfNameDoesNotExists() {
		list.add(airport);
		valid = airport.checkNameExistence(list, str);
		assertTrue(valid);
	}
	@Test
	public void sholudReturnFalseIfNameExists() {
		list.add(airport);
		str="Fly";
		valid = airport.checkNameExistence(list, str);
		assertFalse(valid);
	}
	

}
