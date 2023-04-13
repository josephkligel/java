package com.ninja.zookeeper;

public class Bat extends Mammal {
	
	public Bat() {
		this.energyLevel += 200;
	}
	
	public void fly() {
		System.out.println("Swoosh!");
		
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("the bat ate--so, well, nevermind");
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("Crackle, sssssssss!");
		
		this.energyLevel -= 100;
	}
}
