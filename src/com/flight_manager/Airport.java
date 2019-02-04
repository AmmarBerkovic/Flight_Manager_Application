package com.flight_manager;

import java.util.ArrayList;
import java.util.List;

public class Airport extends CommonMethods {
	private String name;
	public Airport() {

	}

	public Airport(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Airport [name=" + name + "]";
	}

	@Override
	public boolean checkNameLength(String name) {
		if (name.length() > 3) {
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
	
	public boolean checkNameExistence(ArrayList <Airport>list,String name) {
		for (int i = 0; i < list.size(); i++) {
			if(name.equals(list.get(i).getName())) {
				return false;
			}
		}
		return true;
	}


}
