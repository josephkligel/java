package com.ninja.zookeeper;

public class Mammal {
	protected int energyLevel = 100;
	
	public int displayEnergy() {
		System.out.println("Energy is " + this.energyLevel);
		
		return this.energyLevel;
	}
}
