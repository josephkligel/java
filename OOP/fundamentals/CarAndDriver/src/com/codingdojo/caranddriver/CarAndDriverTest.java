package com.codingdojo.caranddriver;

public class CarAndDriverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
//		
//		for(int i=0; i < 4; ++i) {
//			driver.drive();
//		}
//		
//		driver.boost();
//		
//		for(int i=0; i < 3; ++i) {
//			driver.refuel();
//		}
		
//		for(int i = 0; i < 10; ++i) {
//			driver.drive();
//		}
		
		for(int i = 0; i < 9; ++i) {
			driver.drive();
		}
		
		driver.boost();
		
		driver.refuel();
		
		driver.boost();
		
		for(int i = 0; i < 5; ++i) {
			driver.refuel();
		}
		
	}

}
