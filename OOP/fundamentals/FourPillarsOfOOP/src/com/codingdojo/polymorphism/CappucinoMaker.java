package com.codingdojo.polymorphism;

import com.codingdojo.encapsulation.CoffeeMaker;

class CappuccinoMaker extends CoffeeMaker {
	 
    public CappuccinoMaker() {
    	super(16);
        this.maxVolumeOz = 16;
        this.milk = "whole";
    }
                  
    public void brew(String beans) {
	super.brew(beans);
        System.out.println("Frothy!!!");
    }
                  
    public void clean(){
        System.out.println("Cleaning the froth!");
    }
}


