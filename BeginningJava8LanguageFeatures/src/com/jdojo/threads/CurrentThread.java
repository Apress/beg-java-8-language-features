// CurrentThread.java
package com.jdojo.threads;

public class CurrentThread extends Thread {
	public CurrentThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		Thread t = Thread.currentThread();		 
		String threadName = t.getName();
		System.out.println("Inside run() method: " + threadName);
	}

	public static void main(String[] args) {
		CurrentThread ct1 = new CurrentThread("First Thread");
		CurrentThread ct2 = new CurrentThread("Second Thread");
		ct1.start();
		ct2.start();
		
		// Let us see which thread is executing the following statement
		Thread t = Thread.currentThread();
		String threadName = t.getName();
		System.out.println("Inside main() method: " + threadName);
	}
}
