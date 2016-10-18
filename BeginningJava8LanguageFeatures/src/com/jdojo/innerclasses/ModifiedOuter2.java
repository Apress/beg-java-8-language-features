// ModifiedOuter2.java
package com.jdojo.innerclasses;

public class ModifiedOuter2 {
	// Instance variable for ModifiedOuter2 class 
	private int value = 1116;

	// Inner class starts here 
	public class Inner {
		// Instance variable for Inner class 
		private int value = 1720;

		public void printValue() {
			System.out.println("\nInner - printValue()...");
			System.out.println("Inner: Value = " + value);
			System.out.println("Outer: Value = " + ModifiedOuter2.this.value);
		}
	} // Inner class ends here 

	// Instance method for ModifiedOuter2 class 
	public void printValue() {
		System.out.println("\nOuter - printValue()...");
		System.out.println("Outer: Value = " + value);
	}

	// Another instance method for the ModifiedOuter2 class 
	public void setValue(int newValue) {
		System.out.println("\nSetting Outer's value to " + newValue);
		this.value = newValue;
	}
}
