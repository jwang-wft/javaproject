package com.wang.concurrency;

import java.util.concurrent.TimeUnit;

// the Concurrency API has been introduced back in 2004 with the release of Java 5.
public class StartThread {
	public static void main(String[] args) throws Exception{
		//Java 8 Lambda expression point to Runnable function interface.
		Runnable task = () -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Foo " + threadName);
		    try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println("Bar " + threadName);
		};

		task.run();

		Thread thread = new Thread(task);
		thread.start();

		System.out.println("Done!");
	}
}
