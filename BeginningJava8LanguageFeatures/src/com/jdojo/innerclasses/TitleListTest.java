// TitleListTest.java
package com.jdojo.innerclasses;

import java.util.Iterator;

public class TitleListTest {
	public static void main(String[] args) {
		TitleList tl = new TitleList();

		// Add two titles 
		tl.addTitle("Beginning Java 8");
		tl.addTitle("Scripting in Java");

		// Get the iterator 
		Iterator iterator = tl.titleIterator();

		// Print all titles using the iterator 
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
