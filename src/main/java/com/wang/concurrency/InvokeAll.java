package com.wang.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAll {

	public static void main(String[] args) throws InterruptedException {
		int i = 4;
		int j = 5;
		ExecutorService executor = Executors.newWorkStealingPool();
		// where <String> define the return type
		Callable<String> task1 = () -> "task1";
		Callable<String> task2 = () -> String.format("%d + %d = %d\n", i, j, (i + j));
		Callable<String> task3 = () -> "task3";
		List<Callable<String>> callables = Arrays.asList(task1, task2, task3);

		// 把List转换为Stream，然后map到Lambda功能块调用
		executor.invokeAll(callables).stream().map(future -> {
			try {
				return future.get();
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}).forEach(System.out::println);
	}
}
