package com.codingdojo.caranddriver;

public class Car {
	protected int gas = 10;
	
	public void status() {
		if(this.gas > 0)
			System.out.printf("Gas remaining %d/10\n", this.gas);
		else
			System.out.println("Game over");
	}
}
