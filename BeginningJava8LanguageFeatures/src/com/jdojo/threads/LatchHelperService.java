// LatchHelperService.java
package com.jdojo.threads;

import java.util.concurrent.CountDownLatch;
import java.util.Random;

public class LatchHelperService extends Thread {
    private int ID;
    private CountDownLatch latch;
    private Random random = new Random();

    public LatchHelperService(int ID, CountDownLatch latch) {
        this.ID = ID;
        this.latch = latch;
    }

    public void run() {
        try {
            int startupTime = random.nextInt(30) + 1;

            System.out.println("Service #" + ID + " starting in "
                + startupTime + " seconds...");
            Thread.sleep(startupTime * 1000);
            System.out.println("Service #" + ID + " has started...");
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        } 
        finally {
            // Count down on the latch to indicate that it has started  
            this.latch.countDown();
        }
    }
}
