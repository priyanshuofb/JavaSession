package com.ofb.javaSession;

import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;


public class Tasks extends Thread {

	final static Logger logger = Logger.getLogger(Tasks.class);

    CountDownLatch latch;

	public Tasks(int n, CountDownLatch latch) {
		super(Integer.toString(n));
        this.latch = latch;
    } 
    public void run() {
        try{
			logger.debug(Thread.currentThread().getName() + " Finished");
            latch.countDown();
        }catch(Exception err){
            err.printStackTrace();
        }
    }
}

