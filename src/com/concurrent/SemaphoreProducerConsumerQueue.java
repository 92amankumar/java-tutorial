package com.concurrent;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreProducerConsumerQueue {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(4);
		BufferPriorityQueue buffer = new BufferPriorityQueue();
		service.execute(new ProducerTask(buffer));
		for (int i = 0; i < 3; i++) {
			service.execute(new ConsumerTask(buffer));
		}
		service.shutdown();
	}
}

class ProducerTask implements Runnable {
	private BufferPriorityQueue buffer;

	public ProducerTask(BufferPriorityQueue buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			buffer.put(i);
		}
	}

}

class ConsumerTask implements Runnable {
	private BufferPriorityQueue buffer;

	public ConsumerTask(BufferPriorityQueue buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		buffer.get();
	}

}

class BufferPriorityQueue {
	int i;
	Semaphore sc = new Semaphore(0);
	Semaphore sp = new Semaphore(1);
	Queue<Integer> queue = new PriorityQueue<>();

	// Queue<Integer> queue = new ConcurrentLinkedQueue<>();

	void get() {
		try {
			sc.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Consumer consuming --> " + queue.poll());
		sp.release();
	}

	void put(int i) {
		try {
			sp.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.i = i;
		queue.add(i);
		System.out.println("Producer producing --> " + i);
		sc.release();
	}
}