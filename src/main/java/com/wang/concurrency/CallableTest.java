package com.wang.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableTest {

	public static void main(String[] args) {
		Callable<Integer> task = () -> {
			try {
				TimeUnit.SECONDS.sleep(2);
				return 123;
			} catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);
		executor.shutdown();
		System.out.println("future done? " + future.isDone());

		Integer result = 0;
		try {
			result = future.get(1, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("future done? " + future.isDone());
		System.out.print("result: " + result);
	}

}
