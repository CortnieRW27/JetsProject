package com.skilldistillery.jets.app;

import java.util.Scanner;
import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.Jet;

public class JetsApp {
	AirField airField = new AirField();
	String fileName = "jets.txt";

	Scanner input = new Scanner(System.in);
	private boolean keepAsking = true;

	public static void main(String[] args) {
		JetsApp ja = new JetsApp();
		ja.run();
	}

	public void run() {

		while (keepAsking) {
			System.out.println("1. List the jet fleet.\n" + "2. Fly the jets!\n" + "3. View the fastest jets.\n"
					+ "4. View jet with the longest range\n" + "5. Load all cargo jets.\n" + "6. Dogfight!\n"
					+ "7. Add a jet to the fleet.\n" + "8. Remove a jet from the fleet.\n" + "9.Quit!\n");

			int userChoice = input.nextInt();
			input.nextLine();
			if (userChoice == 1) {
				airField.listFleet();

			} else if (userChoice == 2) {
				airField.fly();
			} else if (userChoice == 3) {
				airField.fastestJet();

			} else if (userChoice == 4) {
				airField.longestRange();

			} else if (userChoice == 5) {
				airField.loadCargoJets();

			} else if (userChoice == 6) {
				airField.dogFight();
				
			} else if (userChoice == 7) {
				airField.addJet();

			} else if (userChoice == 8) {
				airField.removeJet();

			} else if (userChoice == 9) {
				System.out.println("GoodBye!");
			}
		}

	}

}
