package com.wang.concurrency;

public class Counter {
	private static volatile int counter;
	
	public synchronized void increment(){
		counter++;
	}

	public int getCounter() {
		return counter;
	}
	
	
}
