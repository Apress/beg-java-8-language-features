// CallTracker.java
package com.jdojo.threads;

public class CallTracker {
	// threadLocal variable is used to store counters for all threads  
	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

	public static void call() {
		int counter = 0 ;
		Integer counterObject = threadLocal.get();

		if (counterObject == null) {
			counter = 1;
		}
		else {
			counter = counterObject.intValue();
			counter++;
		}
	
		// Set the new counter  
		threadLocal.set(counter);
	
		// Print how many times this thread has called this method  
		String threadName = Thread.currentThread().getName(); 
		System.out.println("Call counter for " + threadName + " = " + counter);
	} 
}
