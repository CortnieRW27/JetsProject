package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AirField {
	Scanner input = new Scanner(System.in);
	private List<Jet> fleet = new ArrayList<>();
	private String fileName = "jets.txt";

	// instantiating a fleet of jets ((EMPTY ARRAY))
	public AirField() {
		readJets(fileName);
	}

	public List<Jet> readJets(String fileName) {

		// storing the 5 jets from the text file to this variable fileName

		try (BufferedReader buff = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = buff.readLine()) != null) {
				String[] fleetInfo = line.split(",");
				// the file is not readable so it needs to be input to a readable form and
				// separated by a comma

				String type = fleetInfo[0];
				String model = fleetInfo[1];
				double speed = Double.parseDouble(fleetInfo[2]);
				int range = Integer.parseInt(fleetInfo[3]);
				long price = Long.parseLong(fleetInfo[4]);
				// once its is a readable form it can be parsed into jet objects

				if (type.equals("Fighter")) {
					Jet f = new Fighter(type, model, speed, range, price);
					fleet.add(f);
				} else if (type.equals("Cargo")) {
					Jet c = new CargoPlane(type, model, speed, range, price);
					fleet.add(c);
				} else {
					Jet p = new PassengerJet(type, model, speed, range, price);
					fleet.add(p);
					// the fighter jets are added to the empty array named "f"
					// the cargo jets are added to the array named "c"
					// the passenger jets are added to the array named "p"
				}

			}

		} catch (IOException e) {
			System.out.println(e);
		}
		return fleet;
	}

	public void listFleet() {
		System.out.println(fleet);
	}

	public void fly() {
		for (Jet jet : fleet) {
			double speed = jet.getSpeed();
			int range = jet.getRange();
			double time = range / speed;
			System.out.println(jet + "Flight time: " + time);

		}
	}

	public void fastestJet() {
		double fastJetSpeed = 0;
		Jet fastJet = null;
		for (Jet jet : fleet) {
			if (jet.getSpeed() > fastJetSpeed) {
				fastJetSpeed = jet.getSpeed();
				fastJet = jet;
			}

		}
		System.out.println(fastJet);
	}

	public void longestRange() {
		double longestJetRange = 0;
		Jet rangeJet = null;
		for (Jet jet : fleet) {
			if (jet.getRange() > longestJetRange) {
				longestJetRange = jet.getRange();
				rangeJet = jet;
			}

		}
		System.out.println(rangeJet);
	}

	public void loadCargoJets() {
		for (Jet jet : fleet) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).loadCargoJets();
			}
		}

	}

	public void dogFight() {
		for (Jet jet : fleet) {
			if (jet instanceof Fighter) {
				((Fighter) jet).dogFight();
			}
		}
	}

	public void addJet() {
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("Add a Jet!");
			System.out.println("Type");
			String type = input.next();
			System.out.println("Model");
			String model = input.next();
			System.out.println("Speed");
			double speed = input.nextDouble();
			System.out.println("Range");
			int range = input.nextInt();
			System.out.println("Price");
			long price = input.nextLong();
			fleet.add(new PassengerJet(type, model, speed, range, price));
		} catch (InputMismatchException e) {
			System.out.println("Error");
			input.nextLine();
		}
	}

	public void removeJet() {
		System.out.println("Pick the jet you would like to remove from the list");
        for (int index = 0; index < fleet.size(); index++) {
            System.out.println(index + " " +fleet.get(index));
        }
        int selection =input.nextInt();
        fleet.remove(selection);
	}


	public List<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}

}
