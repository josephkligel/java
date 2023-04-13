package com.ninja.zookeeper;

public class BatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bat bat = new Bat();
		
		// Check bat has energy level of 300
		bat.displayEnergy();
		
		// Attack three towns
		bat.attackTown();
		bat.attackTown();
		bat.attackTown();
		
		// Eat two humans
		bat.eatHumans();
		bat.eatHumans();
		
		// Fly twice
		bat.fly();
		bat.fly();
		
		// Display energy level
		bat.displayEnergy();
	}

}
