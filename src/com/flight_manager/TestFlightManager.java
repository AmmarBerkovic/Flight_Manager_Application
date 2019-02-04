package com.flight_manager;

import java.util.Scanner;

public class TestFlightManager {
	private static Scanner input = new Scanner(System.in);
	static SystemManager sm = new SystemManager();
	static Airport air = new Airport();

	public static void main(String[] args) {
		menu();

	}

	private static void menu() {
		System.out.print(print(0)+"\nInput: ");
		int izbor = ScanInt();
		switch (izbor) {
		case 1:
			System.out.print("Set name: ");
			String name=input.next();
			boolean[] checks = { false, false, false };
			while (checks[0] == false || checks[1] == false || checks[2] == false) {
				checks[0] = false;
				checks[1] = false;
				checks[2] = false;
				if (air.checkNameLength(name))
					checks[0] = true;
				else 
					System.out.println("Error: Name must have consisting of\nexactly three alphabetical characters.");
				if (air.checkIfNameHasOnlyLetters(name))
					checks[1] = true;
				else 
					System.out.println("Error: Name must consist only alphabetical characters.");
				if (air.checkNameExistence(sm.getListOfAirports(), name)) 
					checks[2] = true;
				else 
					System.out.println("Error: Name is already in use.");
				if(checks[0] == false || checks[1] == false || checks[2] == false)
					System.out.print("Try again: ");
					name=ScanStr();
			}
			sm.createAirport(sm.getListOfAirports(), name);
			break;
		case 2:
			break;
		case 3:
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

		return text;
	}

	public static String ScanStr() {
		int cross = 0;
		String str = " ";
		do {
			try {
				str = input.nextLine();
				cross = 1;
			} catch (Exception e) {
				input.nextLine();
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
				input.nextLine();
				System.out.println("Error: " + e);
				System.out.print("Try again: ");
			}
		} while (cross == 0);
		return broj;
	}

}
