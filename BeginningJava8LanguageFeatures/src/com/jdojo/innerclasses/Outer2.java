// Outer2.java
package com.jdojo.innerclasses;

public class Outer2 {
	// Instance variable for Outer2 class 
	private int value = 1116;

	// Inner2 class starts here 
	public class Inner2 {
		// Instance variable for Inner2 class 
		private int value = 1720;
		
		public void printValue() {
			System.out.println("Inner2: Value = " + value);
		}
	} // Inner2 class ends here 

	// Instance method for Outer class 
	public void printValue() {
		System.out.println("Outer2: Value = " + value);
	}

	// Another instance method for Outer2 class 
	public void setValue(int newValue) {
		this.value = newValue;
	}
}
