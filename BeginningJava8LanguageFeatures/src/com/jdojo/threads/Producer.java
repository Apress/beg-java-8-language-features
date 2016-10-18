// Producer.java
package com.jdojo.threads;

import java.util.Random;

public class Producer extends Thread {
	private Buffer buffer;
	
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		Random rand = new Random();
		while(true) {
			// Generate a random integer and store it in the buffer  
			int n = rand.nextInt();
			buffer.produce(n);
		}
	}
}
