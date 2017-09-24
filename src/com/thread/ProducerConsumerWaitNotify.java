package com.thread;

import java.util.ArrayList;
import java.util.List;

class Producer implements Runnable{
	private List<Integer> sharedObj = new ArrayList<>();
	
	public Producer(List<Integer> sharedObj) {
		super();
		this.sharedObj = sharedObj;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			synchronized (sharedObj) {
				while (sharedObj.size() >= 1) {
					try {
						sharedObj.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("Adding to queue "+Thread.currentThread().getName()+ " "+ ++i);
				sharedObj.add(i);
				sharedObj.notify();
				if(i>4)
					break;
			}
		}
	}
}
class Consumer implements Runnable{
	private List<Integer> sharedObj = new ArrayList<>();
	
	public Consumer(List<Integer> sharedObj) {
		super();
		this.sharedObj = sharedObj;
	}
	
	@Override
	public void run() {
		while (true) {
			synchronized (sharedObj) {
				while (sharedObj.size() == 0) {
					try {
						sharedObj.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("Getting from queue "+Thread.currentThread().getName()+ " "+ sharedObj.get(0));
				if(sharedObj.get(0)==5)
					break;
				sharedObj.remove(0);
				sharedObj.notify();
			}
		}
	}
}
public class ProducerConsumerWaitNotify {
	public static void main(String[] args) {
		List<Integer> sharedListObj = new ArrayList<Integer>();
        Thread t1 = new Thread(new Producer(sharedListObj), "Producer");
        Thread t2 = new Thread(new Consumer(sharedListObj), "Consumer");
        t1.start();
        t2.start();    
	}
}
