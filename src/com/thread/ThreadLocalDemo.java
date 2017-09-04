package com.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Accessor implements Runnable {
	private final int id;
	
	public Accessor(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			ThreadLocalDemo.increment();
			System.out.println(this);
			Thread.yield();
		}
	}

	@Override
	public String toString() {
		return "# [" + id + "]" + ThreadLocalDemo.getValue();
	}
}

public class ThreadLocalDemo {
	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
		private Random random = new Random(50);
		@Override
		protected synchronized Integer initialValue() {
			return random.nextInt(10000);
		}
	};
	static void increment(){
		value.set(value.get()+1);
	}
	
	static int getValue(){
		return value.get();
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
			service.execute(new Accessor(i));
		TimeUnit.SECONDS.sleep(3);
		service.shutdownNow();
	}
}
