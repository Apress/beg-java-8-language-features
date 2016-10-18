// WeakHashMapTest.java
package com.jdojo.collections;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {
	public static void main(String[] args) {
		Map<String, String> wMap = new WeakHashMap<>();
		wMap.put(new String("John"), "(342)113-9878");
		wMap.put(new String("Richard"), "(245)890-9045");
		wMap.put(new String("Donna"), "(205)678-9823");
		wMap.put(new String("Ken"), "(205)678-9823");

		System.out.println("Map: " + wMap);
		System.out.println("Map Size: " + wMap.size());

		// If map prints four entries after running the garbage collector, 
		// try running this program after uncommenting the code below, 
		// which may trigger garbage collection  

		/*
		 final int ELEMENT_COUNT = 1000000;
		 String[] junk = new String[ELEMENT_COUNT];
		 for(int i = 0; i < ELEMENT_COUNT; i++) {
			junk[i] = "junk" + i;
		 }
		 */
		
		// Run the garbage collector  
		System.gc();

		System.out.println("After running garbage collector");
		System.out.println("Map: " + wMap);
		System.out.println("Map Size: " + wMap.size());
	}
}
