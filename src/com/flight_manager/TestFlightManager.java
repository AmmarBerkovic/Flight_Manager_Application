package com.flight_manager;

import java.util.Scanner;

public class TestFlightManager {
	private static Scanner input = new Scanner(System.in);
	static SystemManager sm = new SystemManager();
	static Airport port = new Airport();
	static Airline line = new Airline();
	static Flight fly = new Flight();

	public static void main(String[] args) {
		menu();

	}

	private static void menu() {
		String name;
		System.out.print(print(0) + "\n" + print(4));
		int izbor = ScanInt();
		switch (izbor) {
		case 1:
			System.out.print("Set name of Airport: ");
			name = ScanStr();
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
					System.out.println(print(5));
				if (checks[0] == false || checks[1] == false || checks[2] == false)
					System.out.print("Try again: ");
				name = ScanStr();
			}
			sm.createAirport(sm.getListOfAirports(), name);
			System.out.println(print(1));
			menu();
			break;
		case 2:
			System.out.print("Set name of Airline: ");
			name = ScanStr();
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
					System.out.println(print(5));
				if (check[0] == false || check[1] == false || check[2] == false)
					System.out.print("Try again: ");
				name = ScanStr();
			}
			sm.createAirline(sm.getListOfAirlines(), name);
			System.out.println(print(1));
			menu();
			break;
		case 3:
			int port, line;
			String destination, origin;
			System.out.println("Pick airport: ");
			System.out.print(print(7) + "\n" + print(4));
			port = ScanInt();
			System.out.println("Pick airline: ");
			System.out.print(print(8) + "\n" + print(4));
			line = ScanInt();
			System.out.print("Enter destination: ");
			destination = ScanStr();
			System.out.print("Enter origin: ");
			origin = ScanStr();
			sm.createFlight(sm.getListOfFlights(), sm.getListOfAirports().get(port), sm.getListOfAirlines().get(line),
					origin, destination);
			
			System.out.println(print(1));
			menu();
			break;
		case 4:
			Flight temp=null;
			System.out.print("Enter destination: ");
			String dest, org;
			dest = ScanStr();
			System.out.println("Enter origin: ");
			org = ScanStr();
			System.out.println("Enter ID of the flight: ");
			int id;
			System.out.println(
					sm.listTheList(sm.findAvailableFlights(sm.getListOfFlights(), org, dest)) + "\n" + print(4));
			id = ScanInt();
			System.out.println("Pick seat: ");
			for (int i = 0; i < sm.getListOfFlights().size(); i++) {
				if(sm.getListOfFlights().get(i).getId()==id) {
					temp=sm.getListOfFlights().get(i);
					System.out.println(fly.availableSeats(sm.getListOfFlights().get(i)));
				}
			}
			System.out.println("Enter row: ");
			String row;
			row=ScanStr();
			System.out.println("Enter number:");
			int no;
			no=ScanInt();
			for (int i = 0; i < temp.getSeats().size(); i++) {
				if(temp.getSeats().get(i).getRow().equals(row) && temp.getSeats().get(i).getSeatNumber()==no) {
					temp.getSeats().get(i).setAvailable(true);
					System.out.println(print(1));
				}
			}
			menu();
			break;
		case 5:
			System.out.println("Exit!!!");
			System.exit(0);
			break;
		default:
			System.out.print(print(2) + "\n");
			menu();
			break;
		}
	}

	public static String print(int decision) {
		String text = "";
		if (decision == 0)
			text = print(6)
					+ "\n1 - Create Airport\n2 - Create Airline\n3 - Create flight\n4 - Book a seat on a flight\n5 - Izlaz\n"
					+ print(6);
		if (decision == 1)
			text = print(6) + "\nA successful action!";
		if (decision == 2)
			text = print(6) + "\nFailed action!";
		if (decision == 3)
			text = "Error: Name must consist only alphbetical characters.";
		if (decision == 4)
			text = "Input: ";
		if (decision == 5)
			text = "Error: Name is already in use.";
		if (decision == 6)
			text = "============================";

		if (decision == 7) {
			for (int i = 0; i < sm.getListOfAirports().size(); i++) {
				text = text + i + " - " + sm.getListOfAirports().get(i).getName();
			}
		}
		if (decision == 8) {
			for (int i = 0; i < sm.getListOfAirlines().size(); i++) {
				text = text + i + " - " + sm.getListOfAirlines().get(i).getName();
			}
		}
		if (decision == 9) {
			for (int i = 0; i < sm.getListOfFlights().size(); i++) {
				text = text + i + " - " + sm.getListOfAirlines().get(i).getName();
			}
		}

		return text;
	}

	public static String ScanStr() {
		int cross = 0;
		String str = null;
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
				input.next();
				System.out.println("Error: " + e);
				System.out.print("Try again: ");
			}
		} while (cross == 0);
		return broj;
	}

}
