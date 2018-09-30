package com.ofb.javaSession;

import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class CountDownLatchImpl {

	final static Logger logger = Logger.getLogger(CountDownLatchImpl.class);

	public static void main(String[] args) {
		PropertyConfigurator
				.configure("/home/ofb-140/workspace/JavaSession/src/config/log4j.properties");

		int noOfThreads = 1000;
		try {
			CountDownLatch latch = new CountDownLatch(noOfThreads);
			for (int n = 0; n < noOfThreads; n++) {
				Thread t = new Tasks(n, latch);
				t.start();
			}
			latch.await();
			logger.debug("In Main thread after completion of " + noOfThreads
					+ " threads");
		} catch (Exception err) {
			err.printStackTrace();
	        }
	    }
}
