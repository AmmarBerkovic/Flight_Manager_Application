package com.flight_manager;

import java.util.Scanner;

public class TestFlightManager {
	private static Scanner input=new Scanner (System.in);
	static SystemManager sm = new SystemManager();
	static Airport port = new Airport(); 
	static Airline line= new Airline();
	public static void main(String[] args) {
		menu();

	}
	private static void menu() {
		String name;
		System.out.print(print(0)+"\n"+print(4));
		int izbor = ScanInt();
		switch (izbor) {
		case 1:
			System.out.print("Set name of Airport: ");
			name=ScanStr();
			boolean[] checks = { false, false, false };
			while (checks[0] == false || checks[1] == false || checks[2] == false) {
				checks[0] = false;
				checks[1] = false;
				checks[2] = false;
				if (port.checkNameLength(name))
					checks[0] = true;
				else 
					System.out.println("Error: Name must have exactly three alphabetical characters.");
				if (port.checkIfNameHasOnlyLetters(name))
					checks[1] = true;
				else 
					System.out.println(print(3));
				if (port.checkNameExistence(sm.getListOfAirports(), name)) 
					checks[2] = true;
				else 
					System.out.println("Error: Name is already in use.");
				if(checks[0] == false || checks[1] == false || checks[2] == false)
					System.out.print("Try again: ");
					name=ScanStr();
			}
			sm.createAirport(sm.getListOfAirports(), name);
			System.out.println(print(1));
			menu();
			break;
		case 2:
			System.out.print("Set name of Airline: ");
			name=ScanStr();
			boolean[] check = { false, false, false };
			while (check[0] == false || check[1] == false || check[2] == false) {
				check[0] = false;
				check[1] = false;
				check[2] = false;
				if (line.checkNameLength(name))
					check[0] = true;
				else 
					System.out.println("Error: Name must consist less then six alphabetical characters.");
				if (line.checkIfNameHasOnlyLetters(name))
					check[1] = true;
				else 
					System.out.println(print(3));
				if (line.checkNameExistence(sm.getListOfAirlines(), name)) 
					check[2] = true;
				else 
					System.out.println("Error: Name is already in use.");
				if(check[0] == false || check[1] == false || check[2] == false)
					System.out.print("Try again: ");
					name=ScanStr();
			}
			sm.createAirline(sm.getListOfAirlines(), name);
			System.out.println(print(1));
			menu();
			break;
		case 3:
			System.out.println("Pick airport: ");
			for (int i = 0; i < sm.getListOfAirports().size(); i++) {
				System.out.println(i+" - "+sm.getListOfAirports().get(i).getName());
			}
			int port;
			port=ScanInt();
			System.out.println("Pick airline: ");
			for (int i = 0; i < sm.getListOfAirlines().size(); i++) {
				System.out.println(i+" - "+sm.getListOfAirlines().get(i).getName());
			}
			int line;
			line=ScanInt();
			System.out.println("Enter destination: ");
			String destination;
			destination=ScanStr();
			System.out.println("Enter origin: ");
			String origin;
			origin=ScanStr();
			sm.createFlight(sm.getListOfFlights(), sm.getListOfAirports().get(port), sm.getListOfAirlines().get(line),  origin, destination);
			System.out.println(print(1));
			break;
		case 4:
			break;
		case 5:
			System.out.println("Exit!!!");
			System.exit(0);
			break;
		
		}
			}

	public static String print(int decision) {
		String text = "";
		if (decision == 0)
			text = "============================\n1 - Create Airport\n2 - Create Airline\n3 - Create flight\n4 - Book a seat on a flight\n5 - Izlaz\n============================";
		if(decision == 1)
			text = "============================\nA successful action!";
		if(decision == 2)
			text = "============================\nFailed action!";
		if(decision == 3)
			text = "Error: Name must consist only alphbetical characters.";
		if(decision == 4)
			text = "Input: ";
		
		return text;
	}

	public static String ScanStr() {
		int cross = 0;
		String str=null;
		do {
			try {
				str = input.next();
				cross = 1;
			} catch (Exception e) {
				System.out.println("Error: " + e);
				System.out.print("Try again: ");
			}
			
		} while (cross == 0);
		return str;
	}

	public static int ScanInt() {
		int cross = 0, broj = 0;
		do {
			try {
				broj = input.nextInt();
				cross = 1;
			} catch (Exception e) {
				System.out.println("Error: " + e);
				System.out.print("Try again: ");
			}
		} while (cross == 0);
		return broj;
	}

}
