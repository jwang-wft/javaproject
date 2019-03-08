package com.wang.concurrency;
/*
 * In NoVisibility, stale values could cause it to print the wrong value or prevent
the program from terminating.
 */
public class NoVisibility {
	private static volatile boolean ready = false;
	private volatile int number;
	private static class ReaderThread extends Thread {
		NoVisibility nv = new NoVisibility();
		public void run() {
			while (!ready)
				Thread.yield();
			System.out.printf("%s: %d\n", this.getName(), nv.getNumber());
		}
		public void setNumber(int number) {
			nv.setNumber(number);
		}
	}

	public static void main(String[] args) {
		ready = true;
		for (int i = 0; i < 10; i++) {
			ReaderThread rt = new ReaderThread();
			rt.setNumber(i);
			rt.start();
		}
	}

	public synchronized void setNumber(int number) {
		this.number = number;
	}

	public synchronized int getNumber() {
		return number;
	}
}

/**
Output:

Thread-0: 0
Thread-9: 9
Thread-8: 8
Thread-7: 7
Thread-6: 6
Thread-5: 5
Thread-4: 4
Thread-1: 1
Thread-3: 3
Thread-2: 2
**/