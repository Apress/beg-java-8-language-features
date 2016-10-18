// CarTest.java
package com.jdojo.innerclasses;

public class CarTest {
	public static void main(String[] args) {
		// Create an instance of Car with year as 2015 
		Car c = new Car(2015);

		// Create a Tire for that car of 9.0 inch radius 
		Car.Tire t = c.new Tire(9.0);

		System.out.println("Car's year:" + c.getYear());
		System.out.println("Car's tire radius:" + t.getRadius());
	}
}
