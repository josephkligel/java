package com.codingdojo.inheritance;

import com.codingdojo.encapsulation.CoffeeMaker;

class CappuccinoMaker extends CoffeeMaker {
    
    public CappuccinoMaker(int maxVolumeOz) {
        super(maxVolumeOz);
        this.milk = "whole";
    }
    
    public void makeCappuccino(String beans) {
        super.brew(beans);
        System.out.println("Smooth.");
    }
}


