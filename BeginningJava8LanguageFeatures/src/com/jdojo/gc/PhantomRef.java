// PhantomRef.java
package com.jdojo.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomRef {
	public static void main(String[] args){
		BigObject bigObject = new BigObject(1857);
		ReferenceQueue<BigObject> q  = new ReferenceQueue<BigObject> ();
		PhantomReference<BigObject> pr = new PhantomReference<BigObject>(bigObject, q);
		
		/* You can use BigObject reference here */
		
		// Set BigObject to null, so garbage collector will find only the 
		// phantom reference to it and finalize it.
		bigObject = null;
		
		// Invoke garbage collector
		printMessage(pr, "Invoking gc() first time:") ;
		System.gc();
		printMessage(pr, "After invoking gc() first time:");

		// Invoke garbage collector again
		printMessage(pr, "Invoking gc() second time:") ;
		System.gc();
		printMessage(pr, "After invoking gc() second time:");
	}

	public static void printMessage(PhantomReference<BigObject> pr, String msg){	
		System.out.println(msg);
		System.out.println("pr.isEnqueued = " + pr.isEnqueued());
		System.out.println("pr.get() = " + pr.get());

		// We will check if pr is queued. If it has been queued, 
		// we will clear its referent’s reference 
		if (pr.isEnqueued() ) {
			pr.clear();
			System.out.println("Cleared the referent’s reference");
		}
		System.out.println("-----------------------");
	}	
}
