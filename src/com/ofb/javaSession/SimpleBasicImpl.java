package com.ofb.javaSession;

class SimpleBasicImpl {
	public static void main(String args[]) throws InterruptedException {

		Thread FirstThread = new Thread();
		FirstThread.start();
		System.out.println("Thread 1 Executed");
		FirstThread.join();
		for (int i = 2; i < 100; i++) {
			Thread middleThreads = new Thread();
			System.out.println("Thread " + i + " Executed");
			middleThreads.start();
		}
		Thread finalThread = new Thread();
		finalThread.start();
		System.out.println("Thread 100 Executed");

	}

}
