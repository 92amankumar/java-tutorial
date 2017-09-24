package com.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(3, new BarrierAction());
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 3; i++) {
			service.submit(new CyclicFileReader("File-"+(i+1), cb));
		}
		
        System.out.println("Start another set of threads ");

		for (int i = 3; i < 6; i++) {
			service.submit(new CyclicFileReader("File-"+(i+1), cb));
		}
		service.shutdown();
	}
}

class CyclicFileReader implements Runnable {

	private String fileName;
	private CyclicBarrier cb;

	public CyclicFileReader(String fileName, CyclicBarrier cb) {
		super();
		this.fileName = fileName;
		this.cb = cb;
	}

	@Override
	public void run() {
		System.out.println("Reading file " + fileName);
		try {
			System.out.println(cb.await());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
class BarrierAction implements Runnable{
	@Override
	public void run() {
		System.out.println("After Action");
	}
}