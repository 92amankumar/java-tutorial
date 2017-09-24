package com.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Cannot be reused
//Depends on countdown
public class CountDownLatchDemo {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(5);
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			service.submit(new TestFileReader("File-"+(i+1), latch));
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed");
		service.shutdown();
	}
}

class TestFileReader implements Runnable {
	private String fileName;
	private CountDownLatch latch;
	
	public TestFileReader(String fileName, CountDownLatch latch) {
		super();
		this.fileName = fileName;
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Reading file "+fileName);
		latch.countDown();
	}
}