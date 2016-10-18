// CallbackTest.java
package com.jdojo.innerclasses;

import java.util.ArrayList;

public class CallbackTest {
	// To hold all registered Callable objects 
	private ArrayList<Callable> callableList = new ArrayList<>();

	public static void main(String[] args) {
		CallbackTest cbt = new CallbackTest();

		// Create three Callable objects and register them 
		Callable c1 = cbt.generateCallable(1);
		cbt.register(c1);

		Callable c2 = cbt.generateCallable(2);
		cbt.register(c2);

		Callable c3 = cbt.generateCallable(3);
		cbt.register(c3);

		// Callback all the registered Callable objects 
		cbt.callback();
	}

	private void callback() {
		int count = this.callableList.size();

		// Callback all the registered Callable objects 
		for(int i = 0; i < count ; i++) {
			Callable c = this.callableList.get(i);
			c.call();
		}
	}

	public void register(Callable c) {
		this.callableList.add(c);
	}

	public Callable generateCallable(int no) {
		// Note that this object is created here, but it's call() method is 
		// used later. It is also capturing the method parameter no which 
		// will be used in printing a message later. 
		Callable c = new Callable() {
			public void call() {
				System.out.println("Called #" + no);
			}
		};

		return c;
	}
} 
