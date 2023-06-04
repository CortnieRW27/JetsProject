package com.skilldistillery.jets.entities;

public class Fighter extends Jet implements CombatReadyJet {
	@Override
	public void dogFight() {
		System.out.println("I'm fighting, pow! pow!");
	}
	@Override
	public void fly() {
		
	}

	public Fighter(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}

}

