package com.thread;

import java.util.LinkedList;
import java.util.Queue;
//happens-before relationship
class ProducerConsumer {
	private int value = 0;
	private boolean flag = false;

	public void produce(Queue<Integer> sharedListObj) {
		// while flag is true put thread to sleep
		System.out.println("Producing---"+flag);
		while (flag) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		sharedListObj.add(++value);
		System.out.println("Thread " + Thread.currentThread().getName() + " putting " + value);
		flag = true;
		System.out.println("Setting flag value---"+flag);
	}

	public int consume(Queue<Integer> sharedListObj) {
		@SuppressWarnings("unused")
		int j = 0;
		System.out.println("Consuming---"+flag);
		while (!flag)
			j++;
		System.out.println("Getting from queue ");
		int value = sharedListObj.remove();
		flag = false;
		System.out.println("Thread " + Thread.currentThread().getName() + " Consuming " + value);
		return value;
	}
}

public class ProducerConsumerVolatile {
	public static void main(String[] args) {
		Queue<Integer> sharedListObj = new LinkedList<Integer>();
		ProducerConsumer producerConsumer = new ProducerConsumer();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					producerConsumer.produce(sharedListObj);
				}
			}
		}, "ProducerThread").start();

		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				producerConsumer.consume(sharedListObj);
			}

		} , "ConsumerThread").start();

	}
}
