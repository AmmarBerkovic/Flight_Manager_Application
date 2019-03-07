package com.flight_manager;

import java.util.ArrayList;

public class Airline extends CommonMethods {

	private String name;

	public Airline() {

	}

	public Airline(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public boolean checkNameLength(String name) {
		if (name.length() > 6) {
			return false;
		} else if (name.length() == 0) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean checkIfNameHasOnlyLetters(String name) {
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isLetter(name.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkNameExistence(ArrayList<Airline> list, String name) {
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getName())) {
				return false;
			}
		}
		return true;
	}

}
