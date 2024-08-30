package com.shubhamklogic.practice.tricky.java.programs;

class House {
	
	private String colour;
	
	public String getColor() {
		return colour;
	}
	
	public void setColor(String theColour) {
		colour = theColour;
	}
}

class Main {
	
	public static void main(String[] args) {
		
		// Created myHouse object -
		House myHouse = new House();
		
		// Set it's member variable color with value "Blue" -
		myHouse.setColor("Blue");
		
		
	}
}
