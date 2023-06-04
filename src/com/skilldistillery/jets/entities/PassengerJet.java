package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet {

	public PassengerJet(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}
	@Override
	public void fly() {
	}
}
