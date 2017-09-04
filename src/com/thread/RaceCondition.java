package com.thread;

class Counter implements Runnable {
	private int c = 0;

	private void increment() {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		c++;
	}

	private void decrement() {
		c--;
	}

	private int getValue() {
		return c;
	}

	@Override
	public void run() {
		this.increment();
		System.out.println(
				"Value for Thread After increment " + Thread.currentThread().getName() + " " + this.getValue());
		// decrementing
		this.decrement();
		System.out.println("Value for Thread at last " + Thread.currentThread().getName() + " " + this.getValue());
	}

}

public class RaceCondition {
	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread t1 = new Thread(counter, "Thread-1");
		Thread t2 = new Thread(counter, "Thread-2");
		Thread t3 = new Thread(counter, "Thread-3");
		t1.start();
		t2.start();
		t3.start();
	}
}
