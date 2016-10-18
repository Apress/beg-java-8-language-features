// BadRunnableTask.java
package com.jdojo.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BadRunnableTask {
	public static void main(String[] args) {
		Runnable badTask = () -> {			
			throw new RuntimeException("Throwing exception from task execution...");
		};

		ExecutorService exec = Executors.newSingleThreadExecutor();
		exec.execute(badTask);
		exec.shutdown();
	}
}
