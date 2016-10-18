// BigObject.java
package com.jdojo.gc;

public class BigObject {
	// Declare a 16KB big array. This choice is arbitrary. We just wanted to use a large 
	// amount of memory  when an object of this class is created.
	private long [] anArray = new long[4096];
	
	// Have an id to track the object
	private long id;
	
	public BigObject(long id) {
		this.id = id;
	}

	// Define finalize() to track the object’s finalization
	public void finalize(){
		System.out.println("finalize() called for id:" + id);
	}

	public String toString() {
		return "BigObject: id = " + id;
	}
}