package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier{
	@Override
	public void loadCargoJets() {
		System.out.println("Loading all the cargo, getting really heavy!");
	}
	@Override
	public void fly() {
		
	}
	

	public CargoPlane(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}
}
