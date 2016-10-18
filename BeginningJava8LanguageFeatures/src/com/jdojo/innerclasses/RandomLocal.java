// RandomLocal.java
package com.jdojo.innerclasses;

public class RandomLocal {
	public RandomInteger getRandomInteger() {
		// Local inner class that inherits RandomInteger class 
		class RandomIntegerLocal extends RandomInteger {
			@Override
			public int getValue() {
				// Get two random integers and return the average 
				// ignoring the fraction part 
				long n1 = rand.nextInt();
				long n2 = rand.nextInt();

				int value = (int) ((n1 + n2)/2);
				return value;
			}
		}

		return new RandomIntegerLocal();
	} // End of getRandomInteger() method 
}
