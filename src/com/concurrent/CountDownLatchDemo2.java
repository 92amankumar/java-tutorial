package com.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo2 {
	public static void main(String[] args) {
		int count = 2;
		ExecutorService ex = Executors.newFixedThreadPool(count);
		CountDownLatch latch = new CountDownLatch(count);
		for (int i = 1; i <= count; i++)
			ex.execute(() -> {
				String name = Thread.currentThread().getName();
				System.out.println("Starting thread " + name);
				try {
					Thread.sleep(100);
				} catch (Exception e) {
				}
				System.out.println("Pre-Notification work completed " + name);
				latch.countDown();
				try {
					Thread.sleep(100);
				} catch (Exception e) {
				}
				System.out.println("Post-Notification Work Completed" + name);
			});
//		try {
//			latch.await();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		// 
		// 
		ex.shutdown();
		try {
			ex.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finishing Execution");
	}
}