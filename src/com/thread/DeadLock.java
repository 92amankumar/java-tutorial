package com.thread;

public class DeadLock {
	public static void main(String[] args) {
		DeadLock obj1 = new DeadLock();
		DeadLock obj2 = new DeadLock();
		Thread t1 = new Thread(new ThreadA(obj1, obj2), "Thread-1");
        Thread t2 = new Thread(new ThreadB(obj1, obj2), "Thread-2");
        t1.start();
        t2.start();
	}
}

class ThreadA implements Runnable {
	private DeadLock d1;
	private DeadLock d2;

	public ThreadA(DeadLock d1, DeadLock d2) {
		super();
		this.d1 = d1;
		this.d2 = d2;
	}

	@Override
	public void run() {
		synchronized (d1) {
			System.out.println("" + Thread.currentThread().getName());
			synchronized (d2) {
				System.out.println("Reached here");
			}
		}
	}

}

class ThreadB implements Runnable {
	private DeadLock d1;
	private DeadLock d2;

	public ThreadB(DeadLock d1, DeadLock d2) {
		super();
		this.d1 = d1;
		this.d2 = d2;
	}

	@Override
	public void run() {
		synchronized (d2) {
			System.out.println("" + Thread.currentThread().getName());
			synchronized (d1) {
				System.out.println("Reached here");
			}
		}
	}

}