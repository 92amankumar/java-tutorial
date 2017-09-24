package com.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		Semaphore sp = new Semaphore(1);
		System.out.println(sp.availablePermits());
		SharedCounter counter = new SharedCounter(sp);
		for (int i = 0; i < 5; i++) {
			service.submit(counter);
		}
		service.shutdown();
	}
}

class SharedCounter implements Runnable {
	private Semaphore sp;
	private Integer i = 0;

	public SharedCounter(Semaphore sp) {
		this.sp = sp;
	}

	private void increment() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		i++;
	}

	private void decrement() {
		i--;
	}

	private Integer getValue() {
		return i;
	}

	@Override
	public void run() {
		try {
			sp.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.increment();
		System.out.println("After Increment " + Thread.currentThread().getName() + " " + this.getValue());
		this.decrement();
		System.out.println("After Decrement " + Thread.currentThread().getName() + " " + this.getValue());
		sp.release();
	}
}