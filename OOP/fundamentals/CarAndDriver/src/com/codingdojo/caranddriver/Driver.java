package com.codingdojo.caranddriver;

public class Driver extends Car {
	
	public void drive(){
		this.gas -= 1;
		
		System.out.println("You drive the car");
		this.status();
	}
	
	public void boost() {
		if(this.gas >= 3) {
			this.gas -= 2;
			
			System.out.println("You use the boosters");
			this.status();
		} else {
			System.out.println("Must have a gas level of 3 or more to use boosters");
			this.status();
		}
	}
	
	public void refuel() {
		if(this.gas <= 8) {
			this.gas += 2;
			
			System.out.println("You refuel the car");
			this.status();
		} else {
			System.out.println("You cannot refuel with a gas level higher than 8");
			this.status();
		}
	}
}
